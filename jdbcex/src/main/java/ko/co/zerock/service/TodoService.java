package ko.co.zerock.service;

import org.modelmapper.ModelMapper;

import ko.co.zerock.dao.TodoDAO;
import ko.co.zerock.domain.TodoVO;
import ko.co.zerock.dto.TodoDTO;
import ko.co.zerock.util.MapperUtil;
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
	
}
