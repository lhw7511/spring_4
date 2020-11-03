package com.choa.s4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	
	public String summernote(MultipartFile file,HttpSession httpSession)throws Exception{
		String path = httpSession.getServletContext().getRealPath("/resources/upload/notice");
		System.out.println(path);
		File dest = new File(path);
		String name= fileSaver.save(file,dest);
		return name;
		
	}
	
	
	public boolean summernoteDelete(String file,HttpSession httpSession)throws Exception{
		String path = httpSession.getServletContext().getRealPath("/resources/upload/notice");
		File dest = new File(path,file);
		boolean result =false;
		if(dest.exists()) {
			result= dest.delete();
		}
		return result;
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession httpSession) throws Exception {
		String path = httpSession.getServletContext().getRealPath("/resources/upload/notice");
		File dest = new File(path);
		String name="";
		
		
		int result= noticeDAO.setInsert(boardDTO);
		if(result>0) {
			for(int i=0;i<files.length;i++) {
				if(i==0) {
					continue;
				}
				if(files[i].getSize()!=0) {
					name=fileSaver.save(files[i], dest);
					BoardFileDTO boardFileDTO = new BoardFileDTO();
					
					boardFileDTO.setNum(boardDTO.getNum());
					boardFileDTO.setFileName(name);
					boardFileDTO.setOriName(files[i].getOriginalFilename());
					result=noticeDAO.setInsertFile(boardFileDTO);
				}
			}
		}
		
		return result;
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO)  throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager)throws Exception{
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getOne(boardDTO);
	}

	

}
