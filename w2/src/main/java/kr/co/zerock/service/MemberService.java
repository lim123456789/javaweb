package kr.co.zerock.service;

import org.modelmapper.ModelMapper;

import kr.co.zerock.dao.MemberDAO;
import kr.co.zerock.domain.MemberVO;
import kr.co.zerock.dto.MemberDTO;
import kr.co.zerock.util.MapperUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
public enum MemberService {
	INSTANCE;
	
	private MemberDAO dao;
	private ModelMapper modelMapper;
	
	MemberService() {
		
		dao = new MemberDAO();
		modelMapper = MapperUtil.INSTANCE.get();
	}
	
	public MemberDTO login(String mid, String mpw) throws Exception{
		MemberVO vo = dao.getWithPassword(mid, mpw);
		
		MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);
		
		return memberDTO;
	}
}
