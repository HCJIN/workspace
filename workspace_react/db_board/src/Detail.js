import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Detail = () => {

  const navigate = useNavigate();
  const {boardNum} = useParams();
  const [boardList, setBoardList] = useState({});


  useEffect(()=>{
    axios
    .get(`/detail/${boardNum}`)
    .then((res)=>{
      setBoardList(res.data);
    })
    .catch((error)=>{
      alert('오류발생!!\n개발자 모드로 콘솔 확인하세요!')
      console.log(error);
    });
  },[])

  function goDelete(boardNum){
    if(window.confirm('삭제하시겠습니까?')){
      axios
      .delete(`/delete/${boardNum}`)
      .then((res)=>{
        alert('삭제완료')
        navigate('/');
      })
      .catch((error)=>{});
    }
  }


  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td>글번호</td>
            <td>{boardList.boardNum}</td>
            <td>작성자</td>
            <td>{boardList.boardWriter}</td>
            <td>작성일</td>
            <td>{boardList.createDate}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={5}>{boardList.boardTitle}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={5}>{boardList.boardContent}</td>
          </tr>
        </tbody>
      </table>
      <div className='btn-div'>
        <button type='button' onClick={()=>{navigate('/')}}>뒤로가기</button>
        <button type='button' onClick={()=>{goDelete(boardList.boardNum)}}>삭제</button>
        <button type='button' onClick={()=>{navigate(`/join/${boardList.boardNum}`)}}>수정</button>
      </div>
    </div>
  )
}

export default Detail