package com.choa.s4.member;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface MemberService {

	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception;
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;
	
	public int setMemberDelete(MemberDTO memberDTO) throws Exception;
	
	public int setMemberInsert(MemberDTO memberDTO,MultipartFile photo,HttpSession httpSession) throws Exception;
	
	public MemberDTO getIdCheck(MemberDTO memberDTO)throws Exception;
}
