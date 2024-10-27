package com.alien.space.model.dto;
/*
 * CREATE TABLE board (
	id INT AUTO_INCREMENT,
    writer VARCHAR(20) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    hit INT DEFAULT 0,
    writedate TIMESTAMP DEFAULT now(),
    PRIMARY KEY(id)
);

 */
public class Board {
	int id;
	String writer, title, content;
	int hit;
	String writedate;
	
	public Board() {
		
	}

	public Board(int id, String writer, String title, String content, int hit, String writedate) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.writedate = writedate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", writer=" + writer + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", writedate=" + writedate + "]";
	}
}
