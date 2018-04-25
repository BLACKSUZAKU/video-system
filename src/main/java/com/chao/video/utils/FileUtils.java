package com.chao.video.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUtils {

	public FileUtils() {

	}

	
	
	public static void upload(String filePath, String fileName, CommonsMultipartFile multipartFile) throws IllegalStateException, IOException{
		File dir = new File(filePath, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// MultipartFile�Դ��Ľ�������
		multipartFile.transferTo(dir);
		System.out.println(filePath + fileName);
	}
	
	public static String buildRoundName(CommonsMultipartFile videoFile){
		Date currentTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		String[] name = videoFile.getOriginalFilename().split("\\.");
		String videoFileName = UUID.randomUUID().toString().substring(0, 10)
				+ format.format(currentTime) + "."
				+ name[name.length-1];
		
		return videoFileName;
	}
	
	public static void deleteFile(String fileName){
		File file = new File(fileName);
		if(file.exists() && file.isFile()){
			if(file.delete()){
				System.out.println("ɾ���ɹ�" + fileName);
			} else {
				System.out.println("ɾ��ʧ��" + fileName);
			}
		}
	}

}
