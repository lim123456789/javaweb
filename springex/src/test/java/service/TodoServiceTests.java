package service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.co.zerock.dto.TodoDTO;
import kr.co.zerock.service.TodoService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TodoServiceTests {

	@Autowired
	private TodoService todoService;
	
	@Test
	public void testRegister() {
		TodoDTO todoDTO = TodoDTO.builder()
				.title("Test........")
				.dueDate(LocalDate.now())
				.writer("user1")
				.build();
		todoService.register(todoDTO);
	}
}
