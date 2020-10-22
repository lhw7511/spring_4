package com.choa.s4.board;

import java.util.List;

import com.choa.s4.util.Pager;

public interface BoardService {

	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	public BoardDTO getOne(BoardDTO boardDTO)throws Exception;
}
