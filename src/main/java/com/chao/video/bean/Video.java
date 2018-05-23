package com.chao.video.bean;


public class Video {
	// ��Ƶ��id
    private Integer videoId;
    // ��Ƶ�ı���
    private String videoTitle;
    // ��Ƶ�ļ��
    private String videoBrief;
    // ��Ƶ�����
    private String videoClass;
    // ��Ƶ�ı�ǩ
    private String videoLabel;
    // ��Ƶ�ķ���url
    private String imgUrl;
    // ��Ƶ�ļ���url
    private String videoUrl;
    // ��Ƶ���ϴ�ʱ��
    private String uploadTime;
    // ��Ƶ��ʱ��
    private Integer videoTime;
    // ��Ƶ�ķ����� 
    private Integer videoVisited;
    // ��Ƶ����������
    private Integer messageCount;

   

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public Integer getVideoVisited() {
		return videoVisited;
	}

	public void setVideoVisited(Integer videoVisited) {
		this.videoVisited = videoVisited;
	}

	public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getVideoBrief() {
        return videoBrief;
    }

    public void setVideoBrief(String videoBrief) {
        this.videoBrief = videoBrief == null ? null : videoBrief.trim();
    }

    public String getVideoClass() {
        return videoClass;
    }

    public void setVideoClass(String videoClass) {
        this.videoClass = videoClass == null ? null : videoClass.trim();
    }

    public String getVideoLabel() {
        return videoLabel;
    }

    public void setVideoLabel(String videoLabel) {
        this.videoLabel = videoLabel == null ? null : videoLabel.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime == null ? null : uploadTime.trim();
    }

    public Integer getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoBrief=" + videoBrief
				+ ", videoClass=" + videoClass + ", videoLabel=" + videoLabel + ", imgUrl=" + imgUrl + ", videoUrl="
				+ videoUrl + ", uploadTime=" + uploadTime + ", videoTime=" + videoTime + ", videoVisited="
				+ videoVisited + ", messageCount=" + messageCount + "]";
	}

    
}