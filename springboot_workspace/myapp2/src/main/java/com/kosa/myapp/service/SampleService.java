package com.kosa.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.domain.SampleDto;
import com.kosa.myapp.repository.SampleRepository;

@Service
public class SampleService {

	@Autowired
	private SampleRepository dao;
	
	public List<SampleDto> getList(SampleDto dto){
		List<SampleDto> list = dao.findAll();
		return list;
	}
	
	public void insert(SampleDto dto) {
		dao.save(dto); //insert도 이거로, update를 하고 싶으면
		//seq값이 있으면 isnert로 파악 없으면 update로 파악한다
	}
	
	public void update(SampleDto dto) {
		dao.save(dto);
	}
	
	public void delete(SampleDto dto) {
		dao.delete(dto);
	}
	
	public List<SampleDto> findTest(SampleDto dto){
		return dao.findByTestOrderBySeqDesc(dto.getTest());
	}
	
	public List<SampleDto> findTest2(SampleDto dto){
		return dao.searchByTest(dto.getTest());
	}
	
}
