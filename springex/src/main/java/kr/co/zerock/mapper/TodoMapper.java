package kr.co.zerock.mapper;

import kr.co.zerock.domain.TodoVO;

public interface TodoMapper {
	String getTime();
	
	void insert(TodoVO todoVO);
}
