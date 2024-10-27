package com.alien.space.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alien.space.model.dao.BoardDao;
import com.alien.space.model.dto.Board;
import com.alien.space.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Transactional
	@Override
	public List<Board> getBoardList() {
		return boardDao.getBoardList();
	}
	
	@Transactional
	@Override
	public Board getBoard(int id) {
		boardDao.updateHit(id);
		return boardDao.getBoard(id);
	}
	
	@Transactional
	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}
	
	@Transactional
	@Override
	public boolean deleteBoard(int id) {
		int result = boardDao.deleteBoard(id); 
		return result == 1;
	}
	
	@Transactional
	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	public List<Board> search(SearchCondition condition){
		return boardDao.search(condition);
	}

}
