package com.kosa.myapp.score.repository;

import java.util.List;

import com.kosa.myapp.score.domain.ScoreDto;

public interface ScoreDao {
	List<ScoreDto> getList(ScoreDto dto);
	ScoreDto getView(ScoreDto dto);
	void insert(ScoreDto dto);
	void update(ScoreDto dto);
	void delete(ScoreDto dto);
}
