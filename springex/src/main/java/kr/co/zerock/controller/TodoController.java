package kr.co.zerock.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.zerock.dto.TodoDTO;
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
	public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes) {
		log.info("POST todo register.........");
		log.info(todoDTO);
		return "redirect:/todo/list";
	}
	
	@GetMapping("/ex1")
	public void ex1(String name, int age) {
		log.info("ex1............");
		log.info("name:" + name);
		log.info("age:" + age);
	}
	
	@GetMapping("/ex2")
	public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
					@RequestParam(name = "age", defaultValue = "20") int age) {
		log.info("ex2............");
		log.info("name:" + name);
		log.info("age:" + age);
	}
	
	@GetMapping("/ex3")
	public void ex3(LocalDate dueDate) {
		log.info("ex3............");
		log.info("dueDate:" + dueDate);
	}
}
