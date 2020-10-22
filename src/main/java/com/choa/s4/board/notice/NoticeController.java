package com.choa.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setInsert(boardDTO);
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
	
}
