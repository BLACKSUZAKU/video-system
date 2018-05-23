package com.chao.video.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.chao.video.bean.Video;
import com.chao.video.bean.VideoMessage;
import com.chao.video.service.VideoService;
import com.chao.video.utils.FileUtils;
import com.chao.video.utils.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

@Controller
@RequestMapping("video")
@CrossOrigin("*")
public class VideoController {
	@Autowired
	private VideoService service;
	
	/**
	 * ����videoMessage����ȡ��Ƶ�б�VideoMessage�����˲�ѯ����Ϣ
	 * @param videoMessage
	 * @param num
	 * @return
	 */
	@RequestMapping("/getVideos")
	@ResponseBody
	public Msg getVideos(@RequestBody VideoMessage videoMessage, @RequestParam Integer num){
		PageHelper.startPage(1, num);
		List<Video> videos = service.getVideosByVideoMessage(videoMessage);
		PageInfo<Video> pageInfo = new PageInfo<>(videos, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/**
	 * ������Ƶid��ȡ��Ƶ
	 * @param id
	 * @return
	 */
	@RequestMapping("/getVideoById")
	@ResponseBody
	public Msg getVideoById(@RequestParam Integer id){
		return Msg.success().add("video", service.getVideoById(id));
	}
	
	/**
	 * ����һ���µ�video���󣬸���video�����id������Ƶ
	 * @param video
	 * @return
	 */
	@RequestMapping("/updateVideoById")
	@ResponseBody
	public Msg updateVideoById(@RequestBody Video video){
		service.updateVideoById(video);
		System.out.println(video);
		return Msg.success();
	}
	
	/*
	 * ������Ƶidɾ����Ƶ
	 */
	@RequestMapping("/delVideoById")
	@ResponseBody
	public Msg deleteVideoById(@RequestParam Integer id){
		service.deleteVideobyPrimaryKey(id);
		return Msg.success();
	}
	
	/*
	 * ��ȡ��Ƶ������б�
	 */
	@RequestMapping("/getVideoClasses")
	@ResponseBody
	public Msg getVideoClasses(){
		return Msg.success().add("videoClasses", service.getVideoClasses());
	}

	/*
	 * ����VideoMessage����ȡvideo�б�VideoMessage�����˲�ѯ����Ϣ
	 */
	@RequestMapping(value = "/getByMessage", method=RequestMethod.POST)
	@ResponseBody
	public Msg getVideosByVideoMessage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="num", defaultValue="10") Integer num,@RequestBody VideoMessage message) {
		PageHelper.startPage(pn, num); // ִ��������䣬�Ϳ���ʵ�ַ�ҳ��ѯ
		List<Video> videos = service.getVideosByVideoMessage(message);
		PageInfo<Video> pageInfo = new PageInfo<>(videos, 5); // ʹ��pageInfo ����װ��ѯ������Ƶ�б�
		return Msg.success().add("pageInfo", pageInfo);
	}

	/*
	 * ������Ƶ
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Msg addVideo(Video video, @RequestParam("videoFile")CommonsMultipartFile videoFile,@RequestParam("imgFile") CommonsMultipartFile imgFile, HttpServletRequest request) throws IOException {

		if(videoFile.getSize() == 0){
			return Msg.fail();
		}
		String videoPath = "d:\\123\\video\\";
		
		//��ȡһ���������
		String videoName = FileUtils.buildRoundName(videoFile);
		
		//����FileUtils��upload���������ļ�
		FileUtils.upload(videoPath, videoName, videoFile);
		
		video.setVideoUrl(videoName);
		
		File file = new File(videoPath + videoName);
		Encoder encoder = new Encoder();
        MultimediaInfo multimediaInfo;
        int stime = 0;
        try {
        	
        	//��ȡ��Ƶ��ʱ��
			multimediaInfo = encoder.getInfo(file);
			stime = (int)multimediaInfo.getDuration();
			stime = stime / 1000;
		} catch (EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		video.setVideoTime(stime);
		
		//������Ƶ����ͼƬ
		if(imgFile.getSize() != 0){
			String imgPath = "d:\\123\\images\\";
			String imgName = FileUtils.buildRoundName(imgFile);
			FileUtils.upload(imgPath, imgName, imgFile);
			video.setImgUrl(imgName);
		}else {
			video.setImgUrl(null);
		}
		
		service.addVideo(video);
		
		return Msg.success().add("video", video);
	}
	
}
