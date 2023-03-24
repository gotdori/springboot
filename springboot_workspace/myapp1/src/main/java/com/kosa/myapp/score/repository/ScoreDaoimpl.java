package com.kosa.myapp.score.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.myapp.score.domain.ScoreDto;

@Repository("scoreDao")
public class ScoreDaoimpl implements ScoreDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<ScoreDto> getList(ScoreDto dto) {
		return sm.selectList("Score_getList", dto);
	}

	@Override
	public ScoreDto getView(ScoreDto dto) {
		return sm.selectOne("Score_getView", dto);
	}

	@Override
	public void insert(ScoreDto dto) {
		sm.insert("Score_insert", dto);
	}

	@Override
	public void update(ScoreDto dto) {
		sm.update("Score_update", dto);
	}

	@Override
	public void delete(ScoreDto dto) {
		sm.delete("Score_delete", dto);
	}

	
}
