package kr.co.zerock.mapper;

import java.util.List;

import kr.co.zerock.domain.TodoVO;
import kr.co.zerock.dto.PageRequestDTO;

public interface TodoMapper {
	String getTime();
	
	void insert(TodoVO todoVO);
	
	List<TodoVO> selectAll();
	
	TodoVO selectOne(Long tno);
	
	void delete(Long tno);
	
	void update(TodoVO todoVO);
	
	List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
	
	int getCount(PageRequestDTO pageRequestDTO);
}
