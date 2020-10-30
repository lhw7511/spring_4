package com.choa.s4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

public class NoticeDAOTest extends MyTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void setInsertTest() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("spring_4 title test");
//		boardDTO.setWriter("spring_4 writer test");
//		boardDTO.setContents("spring_4 contents test");
//		
//		int result=noticeDAO.setInsert(boardDTO);
//		assertNotEquals(0, result);
//	}

	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}
}
