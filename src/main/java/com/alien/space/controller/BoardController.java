package com.alien.space.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alien.space.model.dto.Board;
import com.alien.space.model.dto.SearchCondition;
import com.alien.space.model.service.BoardService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getBoardList(@ModelAttribute SearchCondition condition){
		List<Board> list = boardService.search(condition);
//		List<Board> list = boardService.getBoardList();
		
		try {
			if (list == null || list.isEmpty()) {
	            throw new Exception("게시글이 없습니다.");
	        }
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> getBoard(@PathVariable("id") int id){
		Board board = boardService.getBoard(id);
		
		try {
			if (board == null) {
	            throw new Exception("게시글이 없습니다.");
	        }
			return new ResponseEntity<>(board, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> insertBoard(@ModelAttribute Board board){
		boardService.insertBoard(board);
		
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable("id") int id){
		boolean isDeleted = boardService.deleteBoard(id);
		
		try {
			if (!isDeleted) {
	            throw new Exception("게시글이 삭제되지 않았습니다.");
	        }
			return new ResponseEntity<>(isDeleted, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> updateBoard(@PathVariable("id") int id, @RequestBody Board board){
		board.setId(id);
		boardService.updateBoard(board);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
	}	
}
