CREATE TABLE HOSPITAL_MEMBER(
	MEM_ID VARCHAR(50) PRIMARY KEY
	,	MEM_PW VARCHAR(50) NOT NULL
	, 	MEM_NAME VARCHAR(30) NOT NULL
	,	MEM_ADDR VARCHAR(50)
	,	ADDR_DETAIL VARCHAR(100)
	,	MEM_TEL VARCHAR(30) UNIQUE
	,  POST VARCHAR(10)
	,	MEM_ROLE VARCHAR(30) DEFAULT 'USER'
	,  H_CODE VARCHAR(30) DEFAULT 'H4'
	, 	GENDER VARCHAR(10)
	,	BIRTHDAY VARCHAR(40) NOT NULL
	,	EMAIL VARCHAR(50) NOT NULL
);

DROP TABLE HOSPITAL_MEMBER;

SELECT * FROM HOSPITAL_MEMBER;