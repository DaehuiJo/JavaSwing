CREATE DATABASE bookmanagement;
SHOW DATABASES;
USE bookmanagement;
SHOW TABLES;

/* 관리자 db*/

CREATE TABLE admin (
employeeNumber INT NOT NULL,
id VARCHAR(20) NOT NULL,
PASSWORD VARCHAR(20) NOT NULL,
NAME VARCHAR(20) NOT NULL,
department VARCHAR(20) NOT NULL,
cellphone VARCHAR(20) NOT NULL,
Email VARCHAR(20) NOT NULL,
PRIMARY KEY(id));



/* 명령어 */
SELECT * FROM admin;
DROP TABLE admin;


/* 도서 db */
/* 도서분류 : 1)미분류 2)소설 3)시/에세이 4)경제/경영 5)자기계발 6)인문 7)역사/문화 8)생활/요리" }; */
		

CREATE TABLE book(
book_no INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(30) NOT NULL,			/* 제목 */
author VARCHAR(10) NOT NULL,			/* 저자 */
price VARCHAR(7) NOT NULL,			/* 가격 */
image VARCHAR(100),				/* 이미지 경로 (url) */
isbn VARCHAR(13),				/* isbn 번호 */
publisher VARCHAR(20),				/* 출판사 */
category INT(1)		/* 카테고리 (상단 참조) */
,FOREIGN KEY (category) REFERENCES category(category_no)
);


ALTER TABLE book MODIFY author VARCHAR(30);

INSERT INTO book VALUE (1, '타이틀','저자','가격','이미지','isbn','출판사',3);
INSERT INTO book VALUE (4, '타이틀','저자','가격','이미지','isbn','출판사',3);

UPDATE book SET book_no=20, title='12432sdf', price='234234', isbn='34324', publisher='234234', category=5 WHERE book_no='20' ;

SELECT * FROM book;
DROP TABLE book;

CREATE TABLE category(
category_no INT PRIMARY KEY,
genre VARCHAR(20)
);
SET GLOBAL wait_timeout = 9999999999999999999999;
interactive_timeout=00000000;
DROP TABLE category;

/* 도서분류 : 1)미분류 2)소설 3)시/에세이 4)경제/경영 5)자기계발 6)인문 7)역사/문화 8)생활/요리" }; */

INSERT INTO category VALUE (0,'미분류');
INSERT INTO category VALUE (1,'소설');
INSERT INTO category VALUE (2,'시/에세이');
INSERT INTO category VALUE (3,'경제/경영');
INSERT INTO category VALUE (4,'자기계발');
INSERT INTO category VALUE (5,'인문');
INSERT INTO category VALUE (6,'역사/문화');
INSERT INTO category VALUE (7,'생활/요리');

SELECT * FROM category;
SET FOREIGN_KEY_CHECKS=0;

CREATE VIEW v1 AS SELECT book.book_no, book.title, book.author, book.price, book.image, book.isbn, book.publisher, category.genre FROM book, category WHERE book.category = category.category_no;

SELECT * FROM v1;


CREATE TABLE member(
member_no INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(20) NOT NULL,			/* 이름 */
address VARCHAR(20) NOT NULL,			/* 주소 */
cellphone VARCHAR(20) NOT NULL,	/* 전화 */
email VARCHAR(20)				/* 이메일 */
);
SELECT * FROM member;
DROP TABLE member;

CREATE TABLE rent (
member_no INT,
book_no INT,
confirm INT,
FOREIGN KEY (member_no) REFERENCES member(member_no),
FOREIGN KEY (book_no) REFERENCES book(book_no)
);
-- primary key 

INSERT INTO rent VALUES (1,22,1);
SELECT * FROM rent;

DROP TABLE rent;
DESC rent;
SELECT * FROM book;
SELECT * FROM member;

-- select * from rent r, v1 v where v.book_no=r.book_no;
-- 
SELECT * FROM member AS m, book AS b, rent AS r
WHERE m.member_no=r.member_no AND b.book_no=r.book_no;


--
SELECT r.confirm,m.*,b.* FROM member AS m, book AS b, rent AS r WHERE m.member_no=r.member_no AND b.book_no=r.book_no AND b.title LIKE CONCAT('%','we','%'); 




/* 명령어 */



SELECT * FROM member;
DROP TABLE member;


/* 통계용  명령어 */

/* 가장 많은 책을 본 사람 */
SELECT * FROM member ORDER BY COUNT DESC LIMIT 1;  /* 전체 출력 */
SELECT NAME, COUNT FROM member ORDER BY COUNT DESC LIMIT 1; /* 이름 횟수 출력 */


/* 가장 많이 대여된 책 */
SELECT * FROM book ORDER BY COUNT DESC LIMIT 1;	   /* 전체 출력 */
SELECT title, COUNT FROM book ORDER BY COUNT DESC LIMIT 1; /* 이름 횟수 출력 */




SELECT m.*,n.* FROM (SELECT r.confirm,r.member_no ,b.* FROM book AS b LEFT OUTER JOIN rent AS r ON b.book_no=r.book_no) AS n LEFT OUTER JOIN member AS m ON m.member_no=n.member_no WHERE title LIKE CONCAT('%','we','%'); 
