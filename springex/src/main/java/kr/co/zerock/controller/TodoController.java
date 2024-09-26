package kr.co.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
	
	@RequestMapping("/list")
	public void list() {
		log.info("todo list..................");
	}
	
	//@RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public void registerGET() {
		log.info("GET todo register........");
	}
	
	@PostMapping("/register")
	public void registerPost() {
		log.info("POST todo register.........");
	}
}
