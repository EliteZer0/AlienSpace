package com.alien.space.model.dao;

import java.util.List;

import com.alien.space.model.dto.Board;
import com.alien.space.model.dto.SearchCondition;

public interface BoardDao {
	public List<Board> getBoardList();
	public Board getBoard(int id);
	public void insertBoard(Board board);
	public int deleteBoard(int id);
	public void updateBoard(Board board);
	public void updateHit(int id);
	public List<Board> search(SearchCondition condition);
}
