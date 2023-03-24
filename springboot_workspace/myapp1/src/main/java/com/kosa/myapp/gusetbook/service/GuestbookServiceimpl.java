package com.kosa.myapp.gusetbook.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kosa.myapp.gusetbook.domain.GuestbookDto;
import com.kosa.myapp.gusetbook.repository.GuestbookDao;

@Service("guestbookService")
public class GuestbookServiceimpl implements GuestbookService{

	@Resource(name="guestbookDao")
	GuestbookDao dao;
	
	@Override
	public List<GuestbookDto> getList(GuestbookDto dto) {
		return dao.getList(dto);
	}
	
	@Override
	public void insert(GuestbookDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(GuestbookDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(GuestbookDto dto) {
		dao.delete(dto);
	}

	@Override
	public GuestbookDto getView(GuestbookDto dto) {
		return dao.getView(dto);
	}
	
	@Override
	public int getTotalCnt(GuestbookDto dto) {
		return dao.getTotalCnt(dto);
	}
}
