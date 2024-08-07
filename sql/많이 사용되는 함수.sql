-- 많이 사용 하는 함수

SELECT 'JAVA';

-- 문자열 나열 함수
SELECT 'JAVA', 'HELLO', CONCAT('JAVA','HELLO');
SELECT BOARD_NUM, TITLE, CONCAT(BOARD_NUM, '_', TITLE) AS BOARD_INFO
FROM board;

-- 문자열의 길이
SELECT 'JAVA', LENGTH('JAVA'), 'HELLO', LENGTH('HELLO');

-- 일부 문자열 추출
-- 첫번째 : 원본 글
-- 두번째 : 추출 시작 INDEX(1부터 시작)
-- 세번재 : 추출 개수
SELECT 'ABCDEFG', 
	SUBSTRING('ABCDEFG',3),
	SUBSTRING('ABCDEFG', 3, 2);
	
	
SELECT 'Mysql', UPPER('Mysql'), LOWER('Mysql');

-- 문자나 숫자의 자릿수 맞추기
SELECT LPAD('JAVA',5,'#'), RPAD('JAVA', 5, '#');