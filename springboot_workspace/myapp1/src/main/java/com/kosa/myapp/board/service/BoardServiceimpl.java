package com.kosa.myapp.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kosa.myapp.board.domain.BoardDto;
import com.kosa.myapp.board.repository.BoardDao;

@Service("boardService")
public class BoardServiceimpl implements BoardService{

	@Resource(name="boardDao")
	BoardDao boardao;
	
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		return boardao.getList(dto);
	}

	@Override
	public int getTotalCnt(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardao.getTotalCnt(dto);
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardao.getView(dto);
	}

	@Override
	public void insert(BoardDto dto) {
		boardao.insert(dto);
	}

	@Override
	public void update(BoardDto dto) {
		boardao.update(dto);
	}

	@Override
	public void delete(BoardDto dto) {
		boardao.delete(dto);
	}


	
	
}
