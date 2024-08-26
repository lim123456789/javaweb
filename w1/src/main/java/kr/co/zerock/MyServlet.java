package kr.co.zerock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = "/my")
public class MyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7732315617809477257L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
													ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>MyServlet</h1>");
		out.println("</body></html>");
		
	}
	
}
