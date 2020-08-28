package com.gwangyeong.spring_prj_diary.dto;

public class repleViewDto {

	public String rContent;
	public int rNum;
	public int rPostNum;
	public int rUserNum;
	public String uId;
	
	public repleViewDto() {}
	
	public repleViewDto(String rContent, int rNum, int rPostNum, int rUserNum, String uId) {
		this.rContent = rContent;
		this.rNum = rNum;
		this.rPostNum = rPostNum;
		this.rUserNum = rUserNum;
		this.uId = uId;
	}
	
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getrPostNum() {
		return rPostNum;
	}

	public void setrPostNum(int rPostNum) {
		this.rPostNum = rPostNum;
	}

	public int getrUserNum() {
		return rUserNum;
	}

	public void setrUserNum(int rUserNum) {
		this.rUserNum = rUserNum;
	}
	
	
	
}
