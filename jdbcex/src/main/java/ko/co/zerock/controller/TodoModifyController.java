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

@WebServlet(name="todoModifyController", value = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
	private TodoService todoService = TodoService.INSTANCE;
	private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long tno = Long.parseLong(req.getParameter("tno"));
			TodoDTO todoDTO = todoService.get(tno);
			req.setAttribute("dto", todoDTO);
			req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new ServletException("modify get... error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String finishedStr = req.getParameter("finished");
		
		TodoDTO todoDTO = TodoDTO.builder()
				.tno(Long.parseLong(req.getParameter("tno")))
				.title(req.getParameter("tilte"))
				.dueDate(LocalDate.parse(req.getParameter("dueDate")))
				.finished( finishedStr != null && finishedStr.equals("on"))
				.build();
		log.info("/todo/modify POST........");
		log.info("todoDTO");
		
		try {
			todoService.modify(todoDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/todo/list");
	}
	
	
}
