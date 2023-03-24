package com.kosa.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kosa.myapp.domain.MemberDto;
import com.kosa.myapp.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository dao;
	
	public List<MemberDto> getList(MemberDto dto, Pageable pageable){
		//페이징 정보 추가
		return dao.findAll(pageable).getContent();
	}
	
	public long getTotaljCnt(MemberDto dto) {
		return dao.count();
	}
	
	public void insert(MemberDto dto) {
		dao.save(dto);
	}
	
	public void update(MemberDto dto) {
		dao.save(dto);
	}
	
	public void delete(MemberDto dto) {
		dao.delete(dto);
	}
	
	public boolean idCheck(MemberDto dto) {
		MemberDto resultDto = dao.findByUser_Id(dto.getUser_id());
		if(resultDto == null)
			return true;
		else
			return false;
	}
	
	
}
