package com.choa.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;
import com.choa.s4.member.memberFile.MemberFileDAO;
import com.choa.s4.member.memberFile.MemberFileDTO;
import com.choa.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;

	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {

		


		return memberUserDAO.getMemberLogin(memberDTO);
	}

	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberUpdate(memberDTO);
	}

	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberDelete(memberDTO);
	}

	@Override
	public int setMemberInsert(MemberDTO memberDTO, MultipartFile photo, HttpSession httpSession) throws Exception {
		// 어떤 hdd폴더에 어떤이름
		String path = httpSession.getServletContext().getRealPath("/resources/upload/member");
		File dest = new File(path);
		// System.out.println(path);
//		//중복되지 않는 시간
//		//1.시간으로 이름지정
//		Calendar cal = Calendar.getInstance();
//		long time =cal.getTimeInMillis();
//		String name =photo.getOriginalFilename();
//		name=time+"_"+name;
//		File file = new File(path, name);
//		//2. 유니크한 이름 생성하는 객체
//		//name=UUID.randomUUID().toString();
//		//System.out.println(name);
//		//하드디스크에 저장
//		//1.FileCopyUtils 객체의 메서드활용
////		byte [] ar = photo.getBytes();
////		FileCopyUtils.copy(ar, file);
//		
//		//2.MultipartFile 객체의 메서드활용
//		photo.transferTo(file);
		String name = "";
		int result = memberUserDAO.setMemberInsert(memberDTO);
		if (photo.getSize() != 0) {
			name = fileSaver.save(photo, dest);
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setFileName(name);
			memberFileDTO.setOriName(photo.getOriginalFilename());

			result = memberFileDAO.setInsert(memberFileDTO);
		}

		return result;
	}

	@Override
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getIdCheck(memberDTO);
	}
}
