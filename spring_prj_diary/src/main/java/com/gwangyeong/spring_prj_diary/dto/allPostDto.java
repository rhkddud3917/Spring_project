package com.gwangyeong.spring_prj_diary.dto;

public class allPostDto {
	public String pTitle;
	public String pContent;
	
	public allPostDto() {}
	
	public allPostDto(String pTitle, String pContent) {
		this.pTitle = pTitle;
		this.pContent = pContent;
	}
	
	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	
	
}
