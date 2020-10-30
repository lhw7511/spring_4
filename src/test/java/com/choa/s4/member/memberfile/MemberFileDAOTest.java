package com.choa.s4.member.memberfile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.member.memberFile.MemberFileDAO;
import com.choa.s4.member.memberFile.MemberFileDTO;

public class MemberFileDAOTest  extends MyTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	@Test
	public void setInsertTest() throws Exception {
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("admin");
		memberFileDTO.setFileName("fileName1");
		memberFileDTO.setOriName("oriName1");
		
		int result=memberFileDAO.setInsert(memberFileDTO);
		assertNotEquals(0, result);
	}

}
