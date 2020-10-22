package com.choa.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		List<BoardDTO> boardDTOs = qnaService.getList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardDTOs);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert()throws Exception{
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("board", "qna");
		 mv.setViewName("board/boardWrite");
		 return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		int result=qnaService.setInsert(boardDTO);
		String message="Insert 실패";
		if(result>0) {
			message="Insert 성공";
		}
		 ModelAndView mv = new ModelAndView();
		 String path="./qnaList";
		 mv.addObject("msg", message);
		 mv.addObject("path", path);
		 mv.setViewName("common/result");
		 return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		 BoardDTO select = qnaService.getOne(boardDTO);
		 ModelAndView mv = new ModelAndView();
		 if(select!=null) {
			 mv.addObject("select", select);
			 mv.addObject("board", "qna");
			 mv.setViewName("board/boardSelect");
		 }else {
			 mv.addObject("msg", "데이터가 없습니다");
			 mv.addObject("path", "./qnaList");
			 mv.setViewName("common/result");
		 }
		
		 return mv;
	}
	@GetMapping("qnaReply")
	public ModelAndView setReply() {
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("board", "qna");
		 mv.setViewName("board/boardReply");
		 return mv;
	}
	@PostMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception {
		 int result =qnaService.setReply(boardDTO);
		 String message="Insert 실패";
			if(result>0) {
				message="Insert 성공";
			}
			 ModelAndView mv = new ModelAndView();
			 String path="./qnaList";
			 mv.addObject("msg", message);
			 mv.addObject("path", path);
			 mv.setViewName("common/result");
			 return mv;
		
	}
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		String message="Delete 실패";
		if(result>0) {
			message="Delete 성공";
		}
		 ModelAndView mv = new ModelAndView();
		 String path="./qnaList";
		 mv.addObject("msg", message);
		 mv.addObject("path", path);
		 mv.setViewName("common/result");
		 return mv;
	}
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		 BoardDTO dto = qnaService.getOne(boardDTO);
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("board", "qna");
		 mv.addObject("dto", dto);
		 mv.setViewName("board/boardUpdate");
		 return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdatePost(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		String message="Update 실패";
		if(result>0) {
			message="Update 성공";
		}
		 ModelAndView mv = new ModelAndView();
		 String path="./qnaList";
		 mv.addObject("msg", message);
		 mv.addObject("path", path);
		 mv.setViewName("common/result");
		 return mv;
	}
}
