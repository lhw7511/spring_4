package com.choa.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

public class QnaDAOTest extends MyTestCase{
	
	@Autowired
	private QnaDAO qnaDAO;
//	@Test
//	public void setInsertTest() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("spring_4 title test");
//		boardDTO.setWriter("spring_4 writer test");
//		boardDTO.setContents("spring_4 contents test");
//		
//		int result=qnaDAO.setInsert(boardDTO);
//		assertEquals(1, result);
//	}
	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = qnaDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}

}
