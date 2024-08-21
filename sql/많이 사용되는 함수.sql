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

-- 문자열의 좌, 우 공백 제거
SELECT '  AA BB  ',LTRIM('  AA BB  '), RTRIM('  AA BB  '), TRIM('  AA BB  ');

-- 문자열 치환 함수
SELECT '010 1111 2222', REPLACE('010 1111 2222', ' ', '-');

-- 반올림 함수
SELECT 123.456, ROUND(123.456, 2);

-- 연산 및 나머지 연산자
SELECT 10 + 10, 2 * 3, 15 / 4 , MOD(10, 3), 10 % 3;

-- NULL 데이터를 치환하는 함수
SELECT COMM, IFNULL(COMM, 0) FROM emp;

-- 평균 계산 시 NULL데이터 주의!! 
SELECT AVG(COMM) FROM emp;

-- COMM 컬럼의 평균 값을 계산하는 올바른 방법
SELECT ROUND(AVG(IFNULL(COMM, 0)),2) FROM emp;

-- ------------------------------------------------------------ --

-- 단일행 함수 : 데이터의 갯수와 상관없이 조회 하나의 행 결과만 갖는 함수
-- SUM(), MAX(, MIN(), AVG(), COUNT()

SELECT * FROM emp;

-- 모든 사원의 급여 총합 및 커미션 총합을 조회
-- SUM(10, 10) <- 이런 쿼리는 불가
SELECT SUM(SAL), SUM(COMM) FROM emp;

-- SUM() 함수의 위의 함수와의 다른점
-- SUM() 함수는 데이터의 수와 상관없이 무조건 하나의 조회 결과
SELECT LENGTH(ENAME), LENGTH(JOB) FROM emp;

-- *** 쿼리 조회 시 조회하는 모든 컬럼의 조회 행 객수는 모두 일치해야 함!!!
-- 모든 사원의 이름과 급여의 합을 조회
SELECT ENAME, SUM(SAL) FROM emp;

SELECT SUM(SAL), MAX(SAL), MIN(SAL), AVG(SAL), COUNT(SAL) FROM emp;

-- 테이블이 있는 데이터의 수
SELECT COUNT(*) FROM emp;
-- 추천하는 방법 : COUNT(PK)
SELECT COUNT(EMPNO) FROM emp;

-- NULL 데이터를 COUNT에서 제외 함
SELECT COUNT(COMM) FROM emp;

SELECT AVG(COMM) FROM emp;

























