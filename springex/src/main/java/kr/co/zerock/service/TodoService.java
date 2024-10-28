package kr.co.zerock.service;

import java.util.List;

import kr.co.zerock.dto.TodoDTO;

public interface TodoService {
	void register(TodoDTO todoDTO);
	
	List<TodoDTO> getAll();
	
	TodoDTO getOne(Long tno);
	
	void remove(Long tno);
	
	void modify(TodoDTO todoDTO);
}
