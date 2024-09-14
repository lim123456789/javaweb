package kr.co.zerock.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.zerock.dto.MemberDTO;
import kr.co.zerock.service.MemberService;

import javax.servlet.*;
import lombok.extern.log4j.Log4j2;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			log.info("Login check filter.............");
		
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("loginInfo") != null) {
				chain.doFilter(request, response);
				return;
			}
			
			Cookie cookie = findCookie(req.getCookies(), "remember=me");
			
			if(cookie == null) {
				resp.sendRedirect("/login");
				return;
			}
			
			log.info("cookie는 존재하는 상황");
			String uuid = cookie.getValue();
			
			try {
				MemberDTO memberDTO = MemberService.INSTANCE.getBuUUID(uuid);
				
				log.info("쿠키의 값으로 조회한 사용자 정보:" + memberDTO);
				if(memberDTO == null) {
					throw new Exception("Cookie value is not valid");
				}
				session.setAttribute("loginInfo", memberDTO);
				chain.doFilter(request, response);
			} catch(Exception e) {
				e.printStackTrace();
				resp.sendRedirect("/login");
			}
			
			
			if(session.getAttribute("loginInfo")==null) {
				resp.sendRedirect("/login");
				
				return;
			}
			
			chain.doFilter(request, response);
		
	}
	
	private Cookie findCookie(Cookie[] cookies, String name) {
		if(cookies == null || cookies.length == 0) {
			return null;
		}
		
		Cookie result = null;
		for (Cookie ck : cookies) {
		    if (ck.getName().equals(name)) {
		        result = ck;
		        break;
		    }
		}
		
		return result;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
