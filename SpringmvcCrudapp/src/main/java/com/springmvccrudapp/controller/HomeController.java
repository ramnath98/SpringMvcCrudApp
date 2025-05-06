package com.springmvccrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvccrudapp.model.Student;
import com.springmvccrudapp.servicei.StudentServiceI;

@Controller
public class HomeController {
	
	@Autowired
	 StudentServiceI ssi ;

	
	
	@RequestMapping("/")
	public String prelogin() 
	{
		System.out.println("open first page");
		return "login";
	}
	
	@RequestMapping("/openregister")
	public String preRegister()
	{
		return"register";
	}
	@RequestMapping("/savedata")
	public String saveSave(@ModelAttribute Student s)
	{
		ssi.saveData(s);
		return"login";
	}
	
	@RequestMapping("/log")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model m)
	{
		List<Student> list = ssi.login(username, password);
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
			return "success";
		}
		else
		{
			m.addAttribute("msg", "Invalid username and password");
			return "login";
		}
		
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("rollno") int rollno,Model m)
	{
		List<Student> list = ssi.deleteStudent(rollno);
		m.addAttribute("data", list);
		return "success";
	}
	@RequestMapping("/edit")
	public String editStudent(@RequestParam("rollno") int rollno,Model m)
	{
		Student s = ssi.editStudent(rollno);
		m.addAttribute("stu", s);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,Model m)
	{
		List<Student> list = ssi.updateStudent(s);
		m.addAttribute("data", list);
		return "success";
	}
	@RequestMapping("/logout")
	public String logout()
	{
		return "login";
	}
	
	

}
