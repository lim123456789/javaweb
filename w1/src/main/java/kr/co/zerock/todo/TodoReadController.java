package kr.co.zerock.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.zerock.todo.dto.TodoDTO;
import kr.co.zerock.todo.service.TodoService;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

	private static final long serialVersionUID = 8400119270539976060L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/todo/read");
		
		// /todo/
		
		Long tno = Long.parseLong(req.getParameter("tno"));
		
		TodoDTO dto = TodoService.INSTANCE.get(tno);
		
		req.setAttribute("dto", dto);
		
		System.out.println(dto.toString());
		
		req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
		
	}
	
	
}
