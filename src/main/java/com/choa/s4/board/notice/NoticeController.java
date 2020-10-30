package com.choa.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	//@RequestMapping(value = "noticeList",method = RequestMethod.GET)
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		
	 List<BoardDTO> boardDTOs=noticeService.getList(pager);
	 ModelAndView mv = new ModelAndView();
	 mv.addObject("list", boardDTOs);
	 mv.addObject("pager", pager);
	 mv.addObject("board", "notice");
	 mv.setViewName("board/boardList");
	 return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert()throws Exception{
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("board", "notice");
		 mv.setViewName("board/boardWrite");
		 return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO,MultipartFile[] files, HttpSession httpSession)throws Exception{
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getOriginalFilename());
		}
		int result = noticeService.setInsert(boardDTO,files,httpSession);
		String message="Insert 실패";
		if(result>0) {
			message="Insert 성공";
		}
	 ModelAndView mv = new ModelAndView();
		 String path="./noticeList";
		 mv.addObject("msg", message);
		 mv.addObject("path", path);
		 mv.setViewName("common/result");
		 return mv;
	}
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		 BoardDTO select = noticeService.getOne(boardDTO);
		 ModelAndView mv = new ModelAndView();
		 if(select!=null) {
			 mv.addObject("select", select);
			 mv.addObject("board", "notice");
			 mv.setViewName("board/boardSelect");
		 }else {
			 mv.addObject("msg", "데이터가 없습니다");
			 mv.addObject("path", "./noticeList");
			 mv.setViewName("common/result");
		 }
		
		 return mv;
	}
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);
		String message="Delete 실패";
		if(result>0) {
			message="Delete 성공";
		}
		 ModelAndView mv = new ModelAndView();
		 String path="./noticeList";
		 mv.addObject("msg", message);
		 mv.addObject("path", path);
		 mv.setViewName("common/result");
		 return mv;
		
	}
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		 BoardDTO dto = noticeService.getOne(boardDTO);
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("board", "notice");
		 mv.addObject("dto", dto);
		 mv.setViewName("board/boardUpdate");
		 return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdatePost(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		String message="Update 실패";
		if(result>0) {
			message="Update 성공";
		}
		 ModelAndView mv = new ModelAndView();
		 String path="./noticeList";
		 mv.addObject("msg", message);
		 mv.addObject("path", path);
		 mv.setViewName("common/result");
		 return mv;
	}
	
	
}
