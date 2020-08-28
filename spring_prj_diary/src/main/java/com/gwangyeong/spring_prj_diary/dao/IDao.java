package com.gwangyeong.spring_prj_diary.dao;

import java.util.ArrayList;

import com.gwangyeong.spring_prj_diary.dto.allPostDto;
import com.gwangyeong.spring_prj_diary.dto.loginDto;
import com.gwangyeong.spring_prj_diary.dto.postViewDto;
import com.gwangyeong.spring_prj_diary.dto.repleViewDto;

public interface IDao {
	public void signupDao(String name, String id, int password);
	public loginDto loginingDao(String id, int password);
	public ArrayList<allPostDto> allPostDao();
	public void addPostDao(String title, String content, int category, int pUserNum);
	public ArrayList<allPostDto> myPostDao(int pUserNum);
	public postViewDto postViewDao(int pNum);
	public ArrayList<repleViewDto> repleViewDao(int uNum,int pNum);
	public void addRepleDao(int pNum, int uNum, String rContent);
	
}
