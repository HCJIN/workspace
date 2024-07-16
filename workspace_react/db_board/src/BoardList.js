import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const BoardList = () => {

  const navigate = useNavigate();

  const [boardList, setBoardList] = useState([]);

  //게시글 목록 조회
  useEffect(()=>{
    axios
    .get('/boardList')
    .then((res)=>{
      setBoardList(res.data);
    })
    .catch((error)=>{
      alert('오류발생!!\n개발자 모드로 콘솔 확인하세요!')
      console.log(error);
    });
  },[])


  return(
    <div>
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제 목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {boardList.map((board, i)=>{
            return(
              <tr key={i}>
                <td>{board.boardNum}</td>
                <td onClick={()=>{ navigate(`/detail/${board.boardNum}`)}}>{board.boardTitle}</td>
                <td>{board.boardWriter}</td>
                <td>{board.createDate}</td>
              </tr>
            )
          })}
        </tbody>
      </table>
      <div className='btn-div'>
        <button type='button' onClick={()=>{navigate('/writeForm')}}>글쓰기</button>
      </div>
    </div>

  );



}

export default BoardList