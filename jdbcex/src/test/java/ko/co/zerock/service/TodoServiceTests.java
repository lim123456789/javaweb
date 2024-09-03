package ko.co.zerock.service;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ko.co.zerock.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TodoServiceTests {
	
	private TodoService todoService;
	
	@Before
	public void ready() {
		todoService = TodoService.INSTANCE;
	}
	
	@Test
	public void testRegister() throws Exception {
		TodoDTO todoDTO = TodoDTO.builder()
				.title("JDBC Test Title")
				.dueDate(LocalDate.now())
				.build();
		
		log.info("------------------------------------");
		log.info(todoDTO);
		
		todoService.register(todoDTO);
	}
}
