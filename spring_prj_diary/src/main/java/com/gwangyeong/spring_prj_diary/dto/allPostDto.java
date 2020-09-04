package com.gwangyeong.spring_prj_diary.dto;

public class allPostDto {
	public String pTitle;
	public String pContent;
	public int pNum;
	
	public allPostDto() {}
	
	public allPostDto(String pTitle, String pContent, int pNum) {
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pNum = pNum;
	}
	
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
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
