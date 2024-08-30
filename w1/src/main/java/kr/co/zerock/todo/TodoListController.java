package kr.co.zerock.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.zerock.todo.dto.TodoDTO;
import kr.co.zerock.todo.service.TodoService;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet{

	private static final long serialVersionUID = -2049174651164134097L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/todo/list");
		
		List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
		
		req.setAttribute("list", dtoList);
		
		req.getRequestDispatcher("/WEB-INF/todo/list.jsp")
				.forward(req, resp);
	}

}
