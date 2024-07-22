import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const BoardList = () => {

  const navigate = useNavigate();

  const [boardList, setBoardList] = useState([]);

  useEffect(()=>{
    axios('/board/boardList')
    .then((res)=>{
      setBoardList(res.data);
      console.log(res.data)
    })
    .catch((error)=>{
      console.log(error);
    })
  },[])


  return (
    <div className='boardList-div'>
      <div className='login-div'>
        <span onClick={()=>{
          navigate('/login')
        }}>Login</span>
        <span onClick={()=>{
          navigate('/join')
        }}>Join</span>
      </div>
      <p>자유게시판</p>
      <div className='btn-div'>
        <select>
          <option>제목</option>
        </select>
        <input type='text'></input>
        <button type='button'>검색</button>
      </div>
      <table className='boardList-table'>
        <thead>
          <tr>
            <td>No</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.length == 0 ? 
            <tr>
              <td colSpan={4}>등록된 게시글이 없습니다</td>
            </tr> :
            boardList.map((board, i)=>{
              return(
                <tr key={i}>
                  <td>{board.boardNum}</td>
                  <td>{board.title}</td>
                  <td>{board.memId}</td>
                  <td>{board.createDate}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div className='footer-div'>
        <button type='button'>글쓰기</button>
      </div>
    </div>
  )
}

export default BoardList