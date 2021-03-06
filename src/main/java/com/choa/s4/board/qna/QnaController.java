package com.choa.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@PostMapping("summernoteDelete")
	public ModelAndView summernoteDelete(String file,HttpSession httpSession)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boolean result=qnaService.summernoteDelete(file, httpSession);
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("summernote")
	public ModelAndView summernote(MultipartFile file,HttpSession httpSession) throws Exception{
		//System.out.println(file.getOriginalFilename());
	
		String name =qnaService.summernote(file, httpSession);
//		String path =httpSession.getServletContext().getContextPath()+File.separator;
//		path= path+"resources"+File.separator+"upload"+File.separator;
//		path=path+"qna"+File.separator+name;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", name);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileDTO boardFileDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.addObject("fileDTO", boardFileDTO);		
		mv.setViewName("fileDown");
		return mv;
	}
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		List<BoardDTO> boardDTOs = qnaService.getList(pager);
//		boardDTOs=null;
//		BoardDTO boardDTO =boardDTOs.get(0);
//	
//		QnaDTO qnaDTO = (QnaDTO)boardDTO;
//		System.out.println(qnaDTO.getDepth());
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
	public ModelAndView setInsert(BoardDTO boardDTO,MultipartFile[] files, HttpSession httpSession)throws Exception{
		int result=qnaService.setInsert(boardDTO,files,httpSession);
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
	
			 mv.addObject("select", select);
			 mv.addObject("board", "qna");
			 mv.setViewName("board/boardSelect");
		
		
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
