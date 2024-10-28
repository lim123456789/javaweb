package kr.co.zerock.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kr.co.zerock.domain.TodoVO;
import kr.co.zerock.dto.TodoDTO;
import kr.co.zerock.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	private final TodoMapper todoMapper;
	
	private final ModelMapper modelMapper;

	@Override
	public void register(TodoDTO todoDTO) {
		
		log.info(modelMapper);
		
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		log.info(todoVO);
		
		todoMapper.insert(todoVO);
	}
	
	@Override
	public List<TodoDTO> getAll(){
		List<TodoDTO> dtoList = todoMapper.selectAll().stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		return dtoList;
	}
	
	@Override
	public TodoDTO getOne(Long tno) {
		TodoVO todoVO = todoMapper.selectOne(tno);
		TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
		return todoDTO;
	}
	
	@Override
	public void remove(Long tno) {
		todoMapper.delete(tno);
	}
	
	@Override
	public void modify(TodoDTO todoDTO) {
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		todoMapper.update(todoVO);
	}
}
