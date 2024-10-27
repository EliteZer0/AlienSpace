DROP DATABASE IF EXISTS ailienspace;
CREATE DATABASE ailienspace DEFAULT CHARACTER SET utf8mb4;

USE ailienspace;

CREATE TABLE board (
	id INT AUTO_INCREMENT,
    writer VARCHAR(20) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    hit INT DEFAULT 0,
    writedate TIMESTAMP DEFAULT now(),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `nickname` varchar(40) NOT NULL,
  `admin` boolean NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO board(title, writer, content) 
VALUES ("테스트1","김펭귄","테스트1"),
	   ("테스트2","지옥녀","테스트2 테스트2"),
       ("테스트3", "정제리", "테스트3 테스트3 테스트3");

INSERT INTO user
VALUES ("genpuin", "1234", "김펭귄", true),
("girlfromhell", "1234", "지옥녀", true),
("hellojerry", "1234", "제리제리", false),
("zepiya", "1234", "제피", false), -- 제피는 금쪽이로 지으려다가 말았음
("pengmom", "1234", "펭맘", false);

commit;

SELECT * FROM board;
SELECT * FROM user;