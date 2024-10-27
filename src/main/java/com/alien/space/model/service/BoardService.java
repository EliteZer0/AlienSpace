package com.alien.space.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alien.space.model.dto.Board;
import com.alien.space.model.dto.SearchCondition;

public interface BoardService {
	public List<Board> getBoardList();
	public Board getBoard(int id);
	public void insertBoard(Board board);
	public boolean deleteBoard(int id);
	public void updateBoard(Board board);
	public List<Board> search(SearchCondition condition);
}
