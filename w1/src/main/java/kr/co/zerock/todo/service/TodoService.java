package kr.co.zerock.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.co.zerock.todo.dto.TodoDTO;

public enum TodoService {
	INSTANCE;
	
	public void register(TodoDTO todoDTO) {
		System.out.println("DEBUG............" + todoDTO);
	}
	
	public List<TodoDTO> getList(){
		
		List<TodoDTO> todoDTOS = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
		    TodoDTO dto = new TodoDTO();
		    dto.setTno((long) i);
		    dto.setTitle("Todo.." + i);
		    dto.setDueDate(LocalDate.now());
		    
		    todoDTOS.add(dto);
		}
		return todoDTOS;
	}
	
	public TodoDTO get(Long tno) {
		TodoDTO dto = new TodoDTO();
		dto.setTno(tno);
		dto.setTitle("Sample Todo");
		dto.setDueDate(LocalDate.now());
		dto.setFinished(true);
		
		return dto;
	}
}