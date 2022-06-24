package com.example.demo;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
@Autowired
	StudentDAO dao;
@RequestMapping("insert")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	ModelAndView mv=new ModelAndView();
	Student s=new Student();
	s.setName(name);
	s.setEmail(email);
	Student sd=dao.insert(s);
	if(sd!=null) {
		mv.setViewName("status");
	}
	return mv;
}


@RequestMapping("getall")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	ModelAndView mv=new ModelAndView();
	List<Student> s=dao.getall();
	mv.setViewName("display");
	mv.addObject("list", s);
	return mv;
}
}
