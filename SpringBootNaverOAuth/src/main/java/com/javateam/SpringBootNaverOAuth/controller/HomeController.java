package com.javateam.SpringBootNaverOAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		log.info("home");
		return "home";
	} //
	
	@GetMapping("/login/oauth2/authorization/naver")
	public String welcome() {
		log.info("welcome");
		return "welcome";
	} //

}