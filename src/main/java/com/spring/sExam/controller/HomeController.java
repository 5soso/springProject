package com.spring.sExam.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = {"/","/h","/aCheck"}, method = RequestMethod.GET)
	//public String home(Locale locale, Model model, HttpServletRequest request) {
	//int age = request.getParameter("age")==null ? 20 : Integer.parseInt(request.getParameter("age"));
	
	public String home(Locale locale, Model model, HttpServletRequest request,
			@RequestParam(name="age", defaultValue = "0", required = false) int age) {
		logger.info("Welcome home! The client locale is {}.", locale);
		/*
		System.out.println("========================");
		System.out.println("여기는 home get");
		System.out.println("전송된 Name : " + request.getServerName());
		System.out.println("전송된 port : " + request.getServerPort());
		System.out.println("ContextPath : " + request.getContextPath());
		System.out.println("전송된 URL(path) : " + request.getServletPath());
		*/
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		String url = "";
		if(age < 20) url = "a1";
		else if(age >= 20 && age < 30) url = "a2";
		else url = "a3";
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name1", "김말숙"); //model 저장소는 request 저장소와 생명주기가 똑같다. 넘겨주고 끝남.
		model.addAttribute("url", url);
		
		return "home";
	}
	
//	@RequestMapping(value = "/aCheck", method=RequestMethod.POST)
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public String aCheckPost(Model model, HttpServletRequest request) {
		int age = request.getParameter("age")==null ? 0 : Integer.parseInt(request.getParameter("age"));
		/*
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		System.out.println("여기는 home post");
		*/
		
		model.addAttribute("age", age);
		
		String url = "";
		if(age < 20) url = "a1";
		else if(age >= 20 && age < 30) url = "a2";
		else url = "a3";
		
		model.addAttribute("url", url);
		return "home";
	}
	
}
