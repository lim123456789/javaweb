package kr.co.zerock.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener{@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		
		Object obj = event.getValue();
		
		if(name.equals("loginInfo")) {
			log.info("A user logined...........");
			log.info(obj);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}
	
}
