
-- 서브쿼리 : 하나의 쿼리 안에 또 다른 쿼리가 존재하는 문법
-- 서브쿼리는 반드시 () 소괄호 안에 작성한다. 

-- 사원 이름이 김사랑인 사원이 소속된 부서명을 조회 
SELECT * FROM dept;
SELECT * FROM emp;

SELECT DNAME
FROM dept d, emp e
WHERE d.DEPTNO = e.DEPTNO AND ENAME = '김사랑';

SELECT DNAME
FROM dept
WHERE DEPTNO = (SELECT DEPTNO
					FROM emp
					WHERE ENAME = '김사랑');
					
					
-- 모든 사원의 평균 급여보다 더 많은 급여를 갖는 사원의 사번 이름 급여 조회
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL > (SELECT AVG(SAL) FROM emp);

-- 
SELECT EMPNO, ENAME, DATE_FORMAT(HIREDATE, '%Y년%m월%d일')
FROM emp
WHERE DEPTNO = (SELECT DEPTNO
						FROM dept
						WHERE DNAME = '인사부')
AND MONTH(HIREDATE) >= 7;

-- 사번, 사원명, 부서번호, 부서명 조회
SELECT EMPNO, ENAME, DEPTNO, (SELECT DNAME FROM dept WHERE DEPTNO = emp.DEPTNO)
FROM emp;

SELECT * FROM board;
SELECT * FROM board_member;

-- 글번호가 10번 이하인 게시글의 글번호, 제목, 작성자ID, 작성자 이름을 조회

-- 1) 조인
SELECT BOARD_NUM, TITLE, b.MEM_ID, MEM_NAME
FROM board b, board_member m
WHERE b.MEM_ID = m.MEM_ID
AND BOARD_NUM <= 10;

-- 2) 서브쿼리
SELECT BOARD_NUM, TITLE, MEM_ID, (SELECT MEM_NAME FROM board_member WHERE MEM_ID = board.MEM_ID) AS MEM_NAME,
(SELECT MEM_ROLE FROM board_member WHERE MEM_ID = board.MEM_ID) AS MEM_ROLE
FROM board
WHERE BOARD_NUM <=10;













