package com.chao.video.bean;

public class VideoMessage {
	//Ҫ��ѯ����Ϣ
	private String msg;
	//��Ƶ�ķ���
	private String videoClass;
	//��Ƶ���ʱ��
	private Integer maxTime;
	//��Ƶ�����ʱ��
	private Integer minTime;
	//ʹ��ʲô����
	private String order;
	//ʹ���ĸ��ֶν�������
	private String orderType;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getVideoClass() {
		return videoClass;
	}
	public void setVideoClass(String videoClass) {
		this.videoClass = videoClass == null ? null : videoClass.trim();
	}
	public Integer getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}
	public Integer getMinTime() {
		return minTime;
	}
	public void setMinTime(Integer minTime) {
		this.minTime = minTime;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order == null ? null : order.trim();
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public VideoMessage(String msg, String videoClass, Integer maxTime, Integer minTime, String order,
			String orderType) {
		super();
		this.msg = msg;
		this.videoClass = videoClass;
		this.maxTime = maxTime;
		this.minTime = minTime;
		this.order = order;
		this.orderType = orderType;
	}
	public VideoMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VideoMessage [msg=" + msg + ", videoClass=" + videoClass + ", maxTime=" + maxTime + ", minTime="
				+ minTime + ", order=" + order + ", orderType=" + orderType + "]";
	}

	
	
}
