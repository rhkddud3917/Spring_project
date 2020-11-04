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
import com.gwangyeong.spring_prj_diary.dto.postViewDto;
import com.gwangyeong.spring_prj_diary.dto.repleViewDto;


@SessionAttributes("owner")
@Controller
public class DController {

	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/login_page")
	public String login_page(Model model) {
		return "login_page";
	}
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/login_or_signup")
	public ModelAndView login_or_signup(HttpServletRequest request, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		String choose = request.getParameter("choose");
		
		if (choose.equals("log-in")) {
			
			IDao dao = sqlSession.getMapper(IDao.class);
			String uId = request.getParameter("id");
			int uPassword = Integer.parseInt(request.getParameter("password"));
			
			loginDto user_info = dao.loginingDao(uId,uPassword);
			
			if (user_info == null) {
				mv.setViewName("loginfail_page");
				return mv;
			}
			else {
				mv.addObject("owner",user_info.uNum);
				mv.setViewName("redirect:entire_diary_page");
				return mv;
			}
		}
		else {
			mv.setViewName("signup_page");
			return mv;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/making_account")
	public String making_account(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		
		IDao dao = sqlSession.getMapper(IDao.class);
		Map<String, Object> map = model.asMap();
		
		request = (HttpServletRequest) map.get("request");
	
		String uName = request.getParameter("name");
		String uId = request.getParameter("id");
		int uPassword = Integer.parseInt(request.getParameter("password"));
		
		dao.signupDao(uName, uId, uPassword);
		return "login_page";
	}
	
	@RequestMapping("/entire_diary_page")
	public ModelAndView entire_diary_page(@ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		IDao get_entire_posts = sqlSession.getMapper(IDao.class);
		ArrayList<allPostDto> entire_posts;
		entire_posts = get_entire_posts.allPostDao();
		model.addAttribute("entire_posts",entire_posts);
		
		IDao get_my_posts = sqlSession.getMapper(IDao.class);
		ArrayList<allPostDto> my_posts;
		my_posts = get_my_posts.myPostDao(uNum);
		model.addAttribute("my_posts",my_posts);
		
		mv.addObject("owner",uNum);
		mv.setViewName("entire_diary_page");
		return mv;
	}
	
	@RequestMapping("/make_post_page")
	public String make_post_page(Model model) {
		return "make_post_page";
	}
	
	@RequestMapping("/making_post")
	public ModelAndView making_post(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		IDao post_info = sqlSession.getMapper(IDao.class);
	
		String pTitle = request.getParameter("title");
		String pContent = request.getParameter("content");
		int pCategory = Integer.parseInt(request.getParameter("category"));
		int pUserNum = uNum;
		
		post_info.addPostDao(pTitle, pContent, pCategory, pUserNum);
		mv.addObject("owner",uNum);
		mv.setViewName("redirect:entire_diary_page");
		return mv;
	}
	
	@RequestMapping("/post_page")
	public ModelAndView post_page(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		IDao get_post_info = sqlSession.getMapper(IDao.class);
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		postViewDto post_info = get_post_info.postViewDao(pNum);
		model.addAttribute("post_info",post_info);
		
		IDao get_reple_info = sqlSession.getMapper(IDao.class);
		ArrayList<repleViewDto> reple_info = get_reple_info.repleViewDao(uNum,pNum);
		model.addAttribute("reple_info",reple_info);
		
		mv.addObject("owner",uNum);
		mv.setViewName("post_page");
		
		return mv;
	}
	
	@RequestMapping("/making_reple")
	public ModelAndView making_reple(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();

		IDao reple_info = sqlSession.getMapper(IDao.class);
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String rContent = request.getParameter("rContent");
		reple_info.addRepleDao(pNum,uNum,rContent);
		
		mv.addObject("owner",uNum);
		mv.setViewName("redirect:post_page?pNum="+Integer.toString(pNum));
		
		return mv;
	}
	
	@RequestMapping("/deleting_post")
	public ModelAndView deleting_post(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		IDao post_info = sqlSession.getMapper(IDao.class);
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		post_info.deletePostDao(pNum);
		
		mv.addObject("owner",uNum);
		mv.setViewName("redirect:entire_diary_page");
		
		return mv;
	}
	
	@RequestMapping("/going_entire_diary_page")
	public ModelAndView going_entire_diary_page(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("owner",uNum);
		mv.setViewName("redirect:entire_diary_page");
		
		return mv;
	}
	
	@RequestMapping("/going_make_post")
	public ModelAndView going_make_post(HttpServletRequest request, @ModelAttribute("owner") int uNum, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("owner",uNum);
		mv.setViewName("redirect:make_post_page");
		
		return mv;
	}
	
	
}
