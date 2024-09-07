package kr.co.zerock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.java.Log;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.info("login get...........");		
		
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("login post.........");
		
		String mid = req.getParameter("mid");
		String mpw = req.getParameter("mpw");
		
		String str = mid + mpw;
		
		HttpSession session = req.getSession();
		
		session.setAttribute("loginInfo", str);
		
		resp.sendRedirect("/todo/list");
	}
	
	
	
}
