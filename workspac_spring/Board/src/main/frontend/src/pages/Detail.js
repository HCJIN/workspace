import axios from 'axios';
import React, { useEffect, useState } from 'react'
import {getBoardList} from '../apis/boardApi'
import { useNavigate, useParams } from 'react-router-dom';

const Detail = () => {


  const navigate = useNavigate();
  const [boardList, setBoardList] = useState({});
  console.log(boardList)
  const {boardNum} = useParams();
  const [loginInfo, setLoginInfo] = useState({});
  

  useEffect(()=>{
    axios.get(`/board/detail/${boardNum}`)
    .then((res)=>{
      console.log(res.data)
      setBoardList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  useEffect(()=>{
    //로그인 여부 확인, 데이터 없으면 null 나옴
    const loginData = window.sessionStorage.getItem('loginInfo');

    //로그인 정보가 있으면...
    if(loginData != null){
      const result = JSON.parse(loginData);//json을 객체로 변환 
      setLoginInfo(result);//객체로 변환된 로그인 정보를 loginInfo 변수에 저장
    }
  },[])



  return (
    <div className='detail-div'>
      <table className='detail-table'>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{boardList.createDate}</td>
            <td>작성자</td>
            <td>{boardList.memId}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}>{boardList.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>{boardList.content}</td>
          </tr>
        </tbody>
      </table>
      <div className='footer-div'>
        {
          loginInfo.memRole == null && loginInfo.memRole == 'admin' ?
          <>
            <button type='button' onClick={()=>{navigate('/')}}>목록가기</button>
            <button type='button'>삭제</button>
          </> :
          <>
            <button type='button' onClick={()=>{navigate('/')}}>목록가기</button>
            <button type='button'>수정</button>
            <button type='button'>삭제</button>
          </>
        }
      </div>
    </div>
  )
}

export default Detail