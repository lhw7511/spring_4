package com.choa.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	@Override
	public int setInsert(BoardDTO boardDTO,MultipartFile []files, HttpSession httpSession) throws Exception {
		
		String path = httpSession.getServletContext().getRealPath("/resources/upload/qna");
		File dest = new File(path);
		String name="";
		int result =qnaDAO.setInsert(boardDTO);
		
		if(result>0) {
			for(int i=0;i<files.length;i++) {
				if(files[i].getSize()!=0) {
					name=fileSaver.save(files[i], dest);
					BoardFileDTO boardFileDTO = new BoardFileDTO();
					
					boardFileDTO.setNum(boardDTO.getNum());
					boardFileDTO.setFileName(name);
					boardFileDTO.setOriName(files[i].getOriginalFilename());
					result=qnaDAO.setInsertFile(boardFileDTO);
				}
			}
		}
		return result;
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
