package com.gwangyeong.spring_prj_diary.dao;

import java.util.ArrayList;

import com.gwangyeong.spring_prj_diary.dto.allPostDto;
import com.gwangyeong.spring_prj_diary.dto.loginDto;

public interface IDao {
	public void signupDao(String name, String id, int password);
	public loginDto loginingDao(String id, int password);
	public ArrayList<allPostDto> allPostDao();
	public void addPostDao(String title, String content, int category, int pUserNum);
}
