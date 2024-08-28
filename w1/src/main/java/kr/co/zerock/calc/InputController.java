package kr.co.zerock.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inputController" , urlPatterns = "/calc/input")
public class InputController extends HttpServlet {

	private static final long serialVersionUID = 4538596511163778227L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("InputController...doGet...");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
	
		dispatcher.forward(req,resp);
	}
}