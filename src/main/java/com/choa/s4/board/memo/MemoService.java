package com.choa.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s4.util.Pager;

@Service
public class MemoService {
	@Autowired
	private MemoDAO memoDAO;
	
	public List<MemoDTO> getList(Pager pager)throws Exception{
		pager.makeRow();
		//pager.setTotalCount(memoDAO.getCount(pager));
		//pager.makePage();
		return memoDAO.getList(pager);
	}
	
	public int setInsert(MemoDTO memoDTO) throws Exception{
		return memoDAO.setInsert(memoDTO);
	}
	
	public long getCount(Pager pager) throws Exception {
		return memoDAO.getCount(pager);
	}
	
	public MemoDTO getOne(MemoDTO memoDTO)throws Exception{
		return memoDAO.getOne(memoDTO);
	}
	public int setDelete(MemoDTO memoDTO)throws Exception{
		return memoDAO.setDelete(memoDTO);
	}
}
