import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const InBoard = () => {

  const navigate = useNavigate();
  const data = window.sessionStorage.getItem('loginInfo')
  const result = JSON.parse(data);
  const [board, setBoard] = useState({
    title : '',
    content : '',
    memId : result.memId
  });

  function onBoard(e){
    setBoard({
      ...board,
      [e.target.name] : e.target.value
    })
  }


  function goBoard(){
    axios
    .post('/board/inBoard', board)
    .then((res)=>{
      console.log(res.data);
      navigate('/')
    })
    .catch((error)=>{

    })
  }

  return (
    <div className='inBoard-div'>
      <table className='inBoard-table'>
        <tbody>
          <tr>
            <td>제목</td>
            <td>
              <input type='text' name='title' onChange={(e)=>{
                onBoard(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td>
              <input id="content" type='text' name='content' onChange={(e)=>{
                onBoard(e)
              }}></input>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='footer-div'>
        <button type='button' onClick={()=>{ goBoard()}}>글등록</button>
      </div>
    </div>
  )
}

export default InBoard