package kr.co.zerock.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.co.zerock.domain.TodoVO;
import kr.co.zerock.dto.PageRequestDTO;
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
	
	@Test
	public void testSelectAll() {
		List<TodoVO> voList = todoMapper.selectAll();
		voList.forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testSelectOne() {
		TodoVO todoVO = todoMapper.selectOne(3L);
		
		log.info(todoVO);
	}
	
	@Test
	public void testSelectList() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();
		
		List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
		
		voList.forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testSelectSearch() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.types(new String[] {"t","w"})
				.keyword("스프링")
				.finished(true)
				.from(LocalDate.of(2021, 12, 01))
				.to(LocalDate.of(2022, 12, 31))
				.build();
		
		List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
		
		voList.forEach(vo -> log.info(vo));
		
		log.info(todoMapper.getCount(pageRequestDTO));
	}
}
