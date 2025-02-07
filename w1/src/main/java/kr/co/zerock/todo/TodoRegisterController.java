package kr.co.zerock.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet{

	private static final long serialVersionUID = -294888983315992501L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("입력 화면을 볼 수 있도록 구성");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
		
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("입력을 처리하고 목록 페이지로 이동");
		
		resp.sendRedirect("/zerock/todo/list");
	}
}
