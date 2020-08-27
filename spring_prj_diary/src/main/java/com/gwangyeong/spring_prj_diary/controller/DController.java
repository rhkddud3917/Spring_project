package com.gwangyeong.spring_prj_diary.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gwangyeong.spring_prj_diary.dao.IDao;
import com.gwangyeong.spring_prj_diary.dto.allPostDto;
import com.gwangyeong.spring_prj_diary.dto.loginDto;


@SessionAttributes("owner")
@Controller
public class DController {

	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/loginview")
	public String loginview(Model model) {
		return "loginview";
	}
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/choosing")
	public ModelAndView choosing(HttpServletRequest request, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		String choose = request.getParameter("choose");
		System.out.println(choose);
		if (choose.equals("log-in")) {
			IDao dao = sqlSession.getMapper(IDao.class);
			String uId = request.getParameter("id");
			int uPassword = Integer.parseInt(request.getParameter("password"));
			loginDto res = dao.loginingDao(uId,uPassword);
			if (res == null) {
				mv.setViewName("loginfail");
				return mv;
			}
			else {
				mv.addObject("owner",res.uNum);
				mv.setViewName("redirect:diaryhome");
				return mv;
			}
		}
		else {
			mv.setViewName("signup");
			return mv;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/signing")
	public String signing(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		IDao dao = sqlSession.getMapper(IDao.class);
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
	
		String uName = request.getParameter("name");
		String uId = request.getParameter("id");
		int uPassword = Integer.parseInt(request.getParameter("password"));
		
		dao.signupDao(uName, uId, uPassword);
		return "loginview";
	}
	
	@RequestMapping("/diaryhome")
	public ModelAndView diaryhome(@ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<allPostDto> dtos;
		dtos = dao.allPostDao();
		model.addAttribute("dtos",dtos);
		mv.addObject("owner",uNum);
		mv.setViewName("diaryhome");
		return mv;
	}
	
	@RequestMapping("/makeDiaryView")
	public String makeDiaryView(Model model) {
		return "makeDiary";
	}
	
	@RequestMapping("/makeDiary")
	public ModelAndView makeDiary(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		IDao dao = sqlSession.getMapper(IDao.class);
	
		String pTitle = request.getParameter("title");
		String pContent = request.getParameter("content");
		System.out.println(pTitle);
		int pCategory = Integer.parseInt(request.getParameter("category"));
		int pUserNum = uNum;
		System.out.println(pUserNum);
		
		dao.addPostDao(pTitle, pContent, pCategory, pUserNum);
		mv.addObject("owner",uNum);
		mv.setViewName("redirect:diaryhome");
		return mv;
	}
	
}
