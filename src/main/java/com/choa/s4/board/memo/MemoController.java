package com.choa.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	@GetMapping("memoList")
	public ModelAndView getList(Pager pager)throws Exception{
		List<MemoDTO> ar = memoService.getList(pager);
		
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memo/memoTest");
		mv.addObject("list", ar);
		return mv;
	}
	@PostMapping("memoWrite")
	public ModelAndView setInsert(MemoDTO memoDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		 int result = memoService.setInsert(memoDTO);
		 String message="Write Fail";
		 if(result>0) {
			 message="Write Success";
		 }
		 mv.addObject("msg", message);
		 mv.setViewName("common/ajaxResult");
		 return mv;
	}
	
	
	@GetMapping("memoPage")
	public void memoPage()throws Exception{
		
	}
	@PostMapping("memoDelete")
	public ModelAndView memoDelete(MemoDTO memoDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		 int result =memoService.setDelete(memoDTO);
		 String message="Delete Fail";
		 if(result>0) {
			 message="Delete Success";
		 }
		 mv.addObject("msg", message);
		 mv.setViewName("common/ajaxResult");
		 return mv;
	}
}
