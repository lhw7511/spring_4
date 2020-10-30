package com.choa.s4.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.util.Pager;

public interface BoardService {

	public int setInsert(BoardDTO boardDTO,MultipartFile[] files, HttpSession httpSession) throws Exception;
	
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	public BoardDTO getOne(BoardDTO boardDTO)throws Exception;
}
