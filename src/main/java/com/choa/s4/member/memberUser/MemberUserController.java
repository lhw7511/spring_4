package com.choa.s4.member.memberUser;

import java.nio.channels.SeekableByteChannel;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.member.MemberDTO;

@Controller
@RequestMapping(value = "/member/**")
public class MemberUserController {
	@Autowired
	private MemberUserService memberUserService;
	//로그인 폼으로 이동
	@GetMapping("memberLogin")
	public String getMemberLogin() {
		
		return "member/memberLogin";
	}
	//로그인해서 세션세팅
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO,HttpSession httpSession) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO=memberUserService.getMemberLogin(memberDTO);
		
		if(memberDTO!=null) {
			httpSession.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("msg", "로그인 실패!");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	//로그아웃
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession httpSession)throws Exception{
		ModelAndView mv = new ModelAndView();
	
		//웹브라우저 종료
		//일정시간 경과(로그인 후에 요청이 발생하면 시간이 연장)
		//memberDTO를 NULL로함
		//유지시간을 강제로 0으로변경
		httpSession.invalidate();
		mv.addObject("msg", "로그아웃 성공!");
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
	//마이페이지
	@GetMapping("memberPage")
	public ModelAndView getMemberPage()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO,HttpSession httpSession)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO session=(MemberDTO) httpSession.getAttribute("member");
		
		long num=session.getNum();
		memberDTO.setNum(num);		
		int result = memberUserService.setMemberUpdate(memberDTO);
		String message="Update 실패!";
		if(result>0) {
			message="Update 성공!";
			session.setName(memberDTO.getName());
			session.setEmail(memberDTO.getEmail());
			httpSession.setAttribute("member", session);
		}
	
		
		mv.addObject("msg", message);
		mv.addObject("path","./memberPage");
		mv.setViewName("common/result");
		return mv;
	}
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession httpSession)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO  = new MemberDTO();
		MemberDTO session=(MemberDTO) httpSession.getAttribute("member");
		memberDTO.setId(session.getId());
		int result=memberUserService.setMemberDelete(memberDTO);
		String message="Delete 실패!";
		if(result>0) {
			message="Delete 성공!";
			httpSession.invalidate();		
		}
		mv.addObject("msg", message);
		mv.addObject("path","../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("memberJoin")
	public ModelAndView setMemberJoin()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(MemberDTO memberDTO,MultipartFile photo)throws Exception{
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getSize());
		System.out.println(photo.getContentType());
		ModelAndView mv = new ModelAndView();
		//int result=memberUserService.setMemberInsert(memberDTO);
		String message="Insert 실패!";
//		if(result>0) {
//			message="Insert 성공!";
//			
//		
//		}
		mv.addObject("msg", message);
		mv.addObject("path","../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("memberIdCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO=memberUserService.getIdCheck(memberDTO);
		int message=0;
		if(memberDTO==null) {
			message=1;
		}
		 mv.addObject("msg", message);
		 mv.setViewName("common/ajaxResult");
		 return mv;
		
	}
}
