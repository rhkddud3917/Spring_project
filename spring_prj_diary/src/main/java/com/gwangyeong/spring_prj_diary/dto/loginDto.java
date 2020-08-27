package com.gwangyeong.spring_prj_diary.dto;

public class loginDto {
	
	public int uNum = -1;
	
	public loginDto() {
		
	}
	
	public loginDto(int uNum) {
		this.uNum = uNum;
	}


	public int getuNum() {
		return uNum;
	}


	public void setuNum(int uNum) {
		this.uNum = uNum;
	}


}
