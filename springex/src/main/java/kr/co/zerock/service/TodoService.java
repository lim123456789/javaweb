package kr.co.zerock.service;

import java.util.List;

import kr.co.zerock.dto.PageRequestDTO;
import kr.co.zerock.dto.PageResponseDTO;
import kr.co.zerock.dto.TodoDTO;

public interface TodoService {
	void register(TodoDTO todoDTO);
	
	//List<TodoDTO> getAll();
	
	PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
	
	TodoDTO getOne(Long tno);
	
	void remove(Long tno);
	
	void modify(TodoDTO todoDTO);
}
