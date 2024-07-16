import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const WriteForm = () => {

  const [boardList, setBoardList] = useState([]);
  const navigate = useNavigate();

  const [board, setBoard] = useState({
    boardTitle : '',
    boardContent : '',
    boardWriter : ''
  });

  function changeBoard(e){
    setBoard({
      ...board,
      [e.target.name] : e.target.value
    });
  }

  function goJoin(){
    console.log(board)

    axios
    .post('/writeForm',board)
    .then((res)=>{})
    .catch((error)=>{});
    navigate('/');
  }

  return (
    <div>
      <table>
        <tr>
          <td>글번호</td>
          <td>
            <input type='text' name='boardNum' id='boardNum'></input>
          </td>
        </tr>
        <tr>
          <td>제목</td>
          <td>
            <input type='text' name='boardTitle' id='boardTitle' onChange={(e)=>{
              changeBoard(e)
            }}></input>
          </td>
        </tr>
        <tr>
          <td>
            작성자
          </td>
          <td>
            <input type='text' name='boardWriter' id='boardWriter' onChange={(e)=>{
              changeBoard(e)
            }}></input>
          </td>
        </tr>
        <tr>
          <td>작성일</td>
          <td>
            <input type='text'  name='createDate' id='createDate'></input>
          </td>
        </tr>
        <tr>
          <td>내용</td>
          <td>
            <input type='text' name='boardContent' id='boardContent' onChange={(e)=>{
              changeBoard(e)
            }}></input>
          </td>
        </tr>
      </table>
      <button type='button' onClick={()=>{ goJoin() }}>글등록</button>
    </div>
  )
}

export default WriteForm