package com.kosa.myapp.score.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kosa.myapp.score.domain.ScoreDto;
import com.kosa.myapp.score.repository.ScoreDao;

@Service("ScoreService")
public class ScoreServiceimpl implements ScoreService{

	@Resource(name="scoreDao")
	ScoreDao dao;
	
	@Override
	public List<ScoreDto> getList(ScoreDto dto) {
		return dao.getList(dto);
	}
	
	@Override
	public void insert(ScoreDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(ScoreDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(ScoreDto dto) {
		dao.delete(dto);
	}

	@Override
	public ScoreDto getView(ScoreDto dto) {
		return dao.getView(dto);
	}
}
