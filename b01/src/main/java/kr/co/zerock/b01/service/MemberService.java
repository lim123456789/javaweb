package kr.co.zerock.b01.service;

import kr.co.zerock.b01.dto.MemberJoinDTO;

public interface MemberService {

    static class MidExistException extends Exception{

    }

    void join(MemberJoinDTO memberJoinDTO) throws  MidExistException;
}
