package com.kosa.myapp.score.service;

import java.util.List;

import com.kosa.myapp.score.domain.ScoreDto;


public interface ScoreService {
	List<ScoreDto> getList(ScoreDto dto);
	void insert(ScoreDto dto);
	void update(ScoreDto dto);
	void delete(ScoreDto dto);
	ScoreDto getView(ScoreDto dto);
}
