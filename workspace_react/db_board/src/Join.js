import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import Detail from './Detail';

const Join = () => {

  const navigate = useNavigate();
  const {boardNum} = useParams();

  const [board, setBoard] = useState({
    boardNum : boardNum,
    boardTitle : '',
    boardWriter : '',
    boardContent : ''
  });

  function changeBoard(e){
    setBoard({
      ...board,
      [e.target.name] : e.target.value
    })
  }

  function goUpdate(){
      axios
      .post('/join',board)
      .then((res)=>{
        navigate('/')
        console.log(board)
      })
      .catch((error)=>{});
  }


  return (
    <div>
      <table>
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
          <td>내용</td>
          <td>
            <input type='text' name='boardContent' id='boardContent' onChange={(e)=>{
              changeBoard(e)
            }}></input>
          </td>
        </tr>
      </table>
      <button type='button' onClick={(e)=>{ goUpdate() }}>글수정</button>
    </div>
  )
}

export default Join