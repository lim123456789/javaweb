package kr.co.zerock.service;

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
}
