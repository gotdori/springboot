package com.kosa.myapp.gusetbook.service;

import java.util.List;

import com.kosa.myapp.gusetbook.domain.GuestbookDto;

public interface GuestbookService {
	List<GuestbookDto> getList(GuestbookDto dto);
	void insert(GuestbookDto dto);
	void update(GuestbookDto dto);
	void delete(GuestbookDto dto);
	GuestbookDto getView(GuestbookDto dto);
	int getTotalCnt(GuestbookDto dto);
}
