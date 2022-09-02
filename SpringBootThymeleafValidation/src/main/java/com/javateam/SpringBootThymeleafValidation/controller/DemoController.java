package com.javateam.SpringBootThymeleafValidation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.javateam.SpringBootThymeleafValidation.domain.Student;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String getForm(Student student) {
		return "index";
	}

	@PostMapping("/save-student")
	public String submitStudentDetails(@Valid Student student, Errors errors, Model model) {
		
		if (null != errors && errors.getErrorCount() > 0) {
			return "index";
		} else {
			model.addAttribute("successMsg", "가입 성공");
			return "success";
		}
	}

}
