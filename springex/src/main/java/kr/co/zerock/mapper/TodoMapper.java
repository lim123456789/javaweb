package kr.co.zerock.mapper;

import java.util.List;

import kr.co.zerock.domain.TodoVO;

public interface TodoMapper {
	String getTime();
	
	void insert(TodoVO todoVO);
	
	List<TodoVO> selectAll();
	
	TodoVO selectOne(Long tno);
	
	void delete(Long tno);
	
	void update(TodoVO todoVO);
}
