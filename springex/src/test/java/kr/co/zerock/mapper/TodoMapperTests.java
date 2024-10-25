package kr.co.zerock.mapper;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.co.zerock.domain.TodoVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TodoMapperTests {
	@Autowired(required = false)
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}
	
	@Test
	public void testInsert() {
		TodoVO todoVO = TodoVO.builder()
				.title("스프링테스트")
				.dueDate(LocalDate.of(2024, 10, 25))
				.writer("user00")
				.build();
		
		todoMapper.insert(todoVO);
	}
}
