package kr.co.zerock.dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.co.zerock.domain.TodoVO;

public class TodoDAOTests {
	
	private TodoDAO todoDAO;
	
	@Before
	public void ready() {
		todoDAO = new TodoDAO();
	}
	
	@Test
	public void testTime() throws Exception{
		System.out.println(todoDAO.getTime());
	}
	
	@Test
	public void testInsert() throws Exception {
		TodoVO todoVO = TodoVO.builder()
				.title("Sample Title...")
				.dueDate(LocalDate.of(2021, 12, 31))
				.build();
		
		todoDAO.insert(todoVO);
	}
	
	@Test
	public void testList() throws Exception {
		List<TodoVO> list = todoDAO.selectAll();
		list.forEach(vo -> System.out.println(vo));
	}
	
	@Test
	public void testSelectOne() throws Exception {
		Long tno = 1L;
		
		TodoVO vo = todoDAO.selectOne(tno);
		
		System.out.println(vo);
	}
	
	@Test
	public void testUpdateOne() throws Exception {
		TodoVO todoVO= TodoVO.builder()
				.tno(1L)
				.title("Sample Title...")
				.dueDate(LocalDate.of(2021,12,31))
				.finished(true)
				.build();
		
		todoDAO.updateOne(todoVO);
	}
	
}
