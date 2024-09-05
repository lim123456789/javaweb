package ko.co.zerock.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ko.co.zerock.dto.TodoDTO;
import ko.co.zerock.service.TodoService;
import lombok.extern.log4j.Log4j2;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	//private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("/todo/register GET...............");
		req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodoDTO todoDTO = TodoDTO.builder()
				.title(req.getParameter("title"))
				.dueDate(LocalDate.parse(req.getParameter("dueDate")))
				.build();
		
		log.info("/todo/register POST........");
		log.info(todoDTO);
		try {
			todoService.register(todoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/zerock/todo/list");
	}
	
	
}
