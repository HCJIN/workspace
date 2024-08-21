

-- 데이터베이스의 키(KET) 종류
-- KEY : 데이터베이스에서 각 행을 구분하는 식별자를 의미
-- 슈퍼 키(SUPER KEY) : 하나의 행을 식별할 수 있는 하나 이상의 컬럼
-- 후보 키(CANDIDATE KEY) : 기본 키가 될 수 있는 후보
-- 기본 키(PRIMARY KEY, PK) : 후보키 중에 각 행을 구분짓기 위해 결정한 키
-- 대체 키(ALTERNATE KEY) : 후보키 중에서 기본키를 제외한 키
-- 외래 키(FOREIGN KEY, FK) : 다른 테이블의 기본키로 사용되는 키 

-- 로그인, 게시글, 댓글 관련 기능 포함 게시판 프로젝트
-- 테이블 : 회원정보, 게시글 번호, 댓글 정보

-- 회원정보 
-- USER : 일반회원
-- ADMIN : 관리자
CREATE TABLE BOARD_MEMBER (
	MEM_ID VARCHAR(50) PRIMARY KEY
	, MEM_PW VARCHAR(50) NOT NULL
	, MEM_NAME VARCHAR(50) NOT NULL
	, GENDER VARCHAR(10) -- 'male', 'female'
	, MEM_ROLE VARCHAR(20) DEFAULT 'USER'
);

-- 임시 회원 데이터
INSERT INTO board_member(MEM_ID, MEM_PW, MEM_NAME, GENDER, MEM_ROLE
) VALUES ('java', '1111', '김자반', 'male', 'USER');
INSERT INTO board_member(MEM_ID, MEM_PW, MEM_NAME, GENDER, MEM_ROLE
) VALUES ('admin', '1111', '관리자반', 'female', 'ADMIN');

SELECT * FROM board_member;

-- 게시판 (회원만 게시글 작성 가능)
CREATE TABLE BOARD (
	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY
	, TITLE VARCHAR(50) NOT NULL
	, CONTENT VARCHAR(100)
	, MEM_ID VARCHAR(50) REFERENCES board_member (MEM_ID) -- 외래키
	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO BOARD(TITLE, CONTENT, MEM_ID)
VALUES( '1번글', '1번.', 'java');
INSERT INTO BOARD(TITLE, CONTENT, MEM_ID)
VALUES( '2번글', '2번글', 'java');
INSERT INTO BOARD(TITLE, CONTENT, MEM_ID)
VALUES( '3번글', '3번글', 'admin');

SELECT * FROM board;

-- 댓글정보 (회원만 가능)
CREATE TABLE BOARD_REPLY (
	REPLY_NUM INT AUTO_INCREMENT PRIMARY KEY
	, REPLY_CONTENT VARCHAR(50) NOT NULL
	, REPLY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
	, MEM_ID VARCHAR(50) REFERENCES board_member (MEM_ID) -- 외래키
	, BOARD_NUM INT REFERENCES board (BOARD_NUM) -- 외래키
);

INSERT INTO board_reply( REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES( '댓글1', 'java', '1');
INSERT INTO board_reply( REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES( '댓글2', 'java', '2');
INSERT INTO board_reply( REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES( '댓글3', 'java', '1');
INSERT INTO board_reply( REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES( '댓글4', 'admin', '1');
INSERT INTO board_reply( REPLY_CONTENT, MEM_ID, BOARD_NUM)
VALUES( '댓글5', 'admin', '2');

SELECT * FROM board_member;
SELECT * FROM board;
SELECT * FROM board_reply;

-- 데이터 조회 연습
-- 회원의 이름이 '김자반'인 회원이 작성한 게시글의
-- 글번호, 제목, 작성자 아이디, 작성자 이름을 조회, 작성일 기준 최신글부터 조회(내림차순)
SELECT BOARD_NUM, TITLE, board_member.MEM_ID, MEM_NAME
FROM board, board_member
WHERE board_member.MEM_NAME = '김자반'
AND board.MEM_ID = board_member.MEM_ID
ORDER BY CREATE_DATE DESC;

-- 모든 게시글의 글번호, 글 제목, 작성자 및  해당글에 작성된 
-- 댓글의 댓글 내용, 댓글 작성자, 댓글 작성일을 조회
-- 게시글 번호 기준 최신순으로 정렬 후 
-- 같은 게시글에 대한 댓글은 가장 최근에 달린 댓글 순으로 조회
SELECT b.BOARD_NUM, TITLE, b.MEM_ID, 
		REPLY_CONTENT, r.MEM_ID, REPLY_DATE
FROM board b, board_reply r
WHERE r.BOARD_NUM = b.BOARD_NUM
ORDER BY b.BOARD_NUM DESC, r.REPLY_NUM DESC;


DELETE FROM board
WHERE BOARD_NUM = 1;


  SELECT REPLY_NUM
  , REPLY_CONTENT
  , board.MEM_ID
  , REPLY_DATE
  , board.BOARD_NUM
  FROM BOARD_REPLY, BOARD
  WHERE board_reply.BOARD_NUM = board.BOARD_NUM
  AND board.board_num = 1
  ORDER BY REPLY_NUM DESC;
  
SELECT 
	TITLE, 
	CONTENT,
	board.MEM_ID,
	MEM_NAME,
	MEM_ROLE
FROM board, board_member 
WHERE board.MEM_ID = board_member.MEM_ID
AND board.MEM_ID = 'java';

SELECT BOARD_NUM, TITLE, MEM_NAME
FROM board, board_member
WHERE BOARD_NUM <= 5 
AND board.MEM_ID = board_member.MEM_ID
ORDER BY BOARD_NUM ASC;
  

SELECT TITLE, b.MEM_ID, REPLY_CONTENT, r.MEM_ID, m.MEM_NAME
FROM board b, board_reply r, board_member m
WHERE b.BOARD_NUM = 1 
AND b.BOARD_NUM = r.BOARD_NUM && b.MEM_ID = m.MEM_ID;

DELETE FROM board_reply 
WHERE REPLY_NUM > 6;

 -- 게시글 번호, 게시글 제목, 게시글 작성자
 -- 게시글 작성일, 게시글 내용
 -- 댓글 작성일, 댓글 작성자 ID, 댓글 내용
 SELECT B.BOARD_NUM, TITLE, B.MEM_ID
 		,	CREATE_DATE, CONTENT 
 		,	REPLY_DATE, R.MEM_ID, REPLY_CONTENT
 FROM board B, board_reply R
 WHERE B.BOARD_NUM = R.BOARD_NUM
 AND B.BOARD_NUM = 2;
 
 
 CREATE TABLE TEST_ITEM (
 	ITEM_CODE INT AUTO_INCREMENT PRIMARY KEY
 	,	ITEM_NAME VARCHAR(30) NOT NULL
 );
 
INSERT INTO TEST_ITEM VALUES(1,'상품1');
INSERT INTO TEST_ITEM VALUES(2,'상품2');
INSERT INTO TEST_ITEM VALUES(3,'상품3');

SELECT * FROM test_item;

CREATE TABLE TEST_ORDER(
	ORDER_NUM INT AUTO_INCREMENT PRIMARY KEY
	, BUYER VARCHAR(50) NOT NULL
	, ITEM_CODE INT NOT NULL REFERENCES test_item (ITEM_CODE) ON DELETE CASCADE
);
 
INSERT INTO TEST_ORDER VALUES(1, '김자반', 1);
INSERT INTO TEST_ORDER VALUES(2, '김자반', 1);
INSERT INTO TEST_ORDER VALUES(3, '김자반', 2);
 
SELECT * FROM test_order;

DROP TABLE test_order;
DROP TABLE test_item;

DELETE FROM test_item WHERE ITEM_CODE = 1;
 
 
SELECT BOARD_NUM
	, TITLE
	, MEM_ID
	, CREATE_DATE
FROM board
WHERE ${searchType} LIKE CONCAT();
 
SELECT BOARD_NUM
  , TITLE
  , MEM_ID
  , CREATE_DATE
FROM board
ORDER BY BOARD_NUM DESC
LIMIT 5 OFFSET 5;

-- 테이블에 존재하는 데이터 갯수 조회
SELECT COUNT(BOARD_NUM)
FROM board;










