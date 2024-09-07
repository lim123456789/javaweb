package kr.co.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import kr.co.zerock.dao.TodoDAO;
import kr.co.zerock.domain.TodoVO;
import kr.co.zerock.dto.TodoDTO;
import kr.co.zerock.util.MapperUtil;
import lombok.extern.log4j.Log4j2;


@Log4j2
public enum TodoService {
	INSTANCE;
	
	private TodoDAO dao;
	private ModelMapper modelMapper;
	
	TodoService(){
		dao = new TodoDAO();
		modelMapper = MapperUtil.INSTANCE.get();
	}
	
	public void register(TodoDTO todoDTO) throws Exception{
		
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		//System.out.println("todoVO: "+ todoVO);
		
		log.info(todoVO);		
		dao.insert(todoVO);
	}
	
	public List<TodoDTO> listAll() throws Exception {
		
		List<TodoVO> voList = dao.selectAll();
		
		log.info("voList..............");
		log.info(voList);
		
		/*
		 * List<TodoDTO> dtoList = voList.stream() .map(vo -> modelMapper.map(vo,
		 * TodoDTO.class)) .collect(Collectors.toList());
		 */
		
		List<TodoDTO> dtoList = new ArrayList<>();
		
		for(TodoVO todoVO : voList) {
			TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
			dtoList.add(todoDTO);
		}
		
		return dtoList;
	}
	
	public TodoDTO get(Long tno) throws Exception {
		log.info("tno: "+ tno);
		TodoVO todoVO = dao.selectOne(tno);
		TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
		return todoDTO;
	}
	
	public void remove(Long tno) throws Exception {
		log.info("tno: " + tno);
		dao.deleteOne(tno);
	}
	
	public void modify(TodoDTO todoDTO) throws Exception {
		log.info("todoDTO: " + todoDTO);
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		dao.updateOne(todoVO);
	}
}
