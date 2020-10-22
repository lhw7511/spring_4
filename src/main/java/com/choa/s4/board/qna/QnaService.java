package com.choa.s4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(qnaDAO.getCount(pager));
		pager.makePage();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getOne(boardDTO);
	}
	
	public int setReply(BoardDTO boardDTO)throws Exception{
		int result=qnaDAO.setReplyUpdate(boardDTO);
		result=qnaDAO.setReply(boardDTO);
		return result;
	}

}
