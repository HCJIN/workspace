
-- DB 연결 연습용 테이블
CREATE TABLE TEST_MEMBER(
	MEM_NUM INT PRIMARY KEY
		,MEN_NAME VARCHAR(50) 
		,MEM_AGE INT
		,MEN_ADDR VARCHAR(50)
);

SELECT * FROM test_member;

-- 데이터 삽입
INSERT INTO test_member VALUES (1, '홍길동', 20, '서울시');
INSERT INTO test_member VALUES (2, '홍길동2', 21, '광주시');
INSERT INTO test_member VALUES (3, '홍길동3', 22, '부산시');
INSERT INTO test_member VALUES (4, '홍길동4', 23, '대구시');
INSERT INTO test_member VALUES (5, '홍길동5', 24, '울산시');
COMMIT;


