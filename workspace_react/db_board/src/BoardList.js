import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const BoardList = () => {

  const navigate = useNavigate();


  //게시글 목록을 저장할 state 변수
  const [boardList, setBoardList] = useState([]);

  //게시글 목록 데이터 받기
  //useEffect 안의 내용은 마지막에 실행
  useEffect(()=>{
    //서버에서 데이터 받기
    axios
    //데이터를 가져올 url
    .get('/boardList') 
    //데이터 조회 후 실행 할 내용
    //res : 통신 경과 모든 정보가 담긴 객체
    //res.data : 조회한 데이터
    .then((res)=>{
      console.log('조회 성공 !!!');
      setBoardList(res.data);
    })
    //오류 발생 시 실행 할 내용(오류 발생 시에만 실행!!!)
    //error : 오류에 대한 모든 정보가 담긴 객체
    .catch((error)=>{
      console.log('aixos 통신 중 오류 발생!!');
      console.log(error);
    }); 
  },[]);

  return (
    <div>
      <table border='1px' >
        <thead>
          <tr>
            <td>글번호</td>
            <td>제 목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.map((board, i)=>{
              return(
                <tr key={i}>
                  <td>{board.boardNum}</td>
                  <td onClick={()=>{
                    navigate(`/detail/${board.boardNum}`)
                  }} boardList={boardList} setBoardList={setBoardList}>{board.boardTitle}</td>
                  <td>{board.boardWriter}</td>
                  <td>{board.createDate}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default BoardList