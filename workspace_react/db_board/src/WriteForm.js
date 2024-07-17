import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const WriteForm = () => {

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

  //글 등록 버튼 클릭시 실행하는 함수
  function goJoin(){

    //제목이 비었으면? 
    const title_input = document.querySelector('input[name="boardTitle"]');
    if(title_input.value == ''){
      alert('제목은 필수입력입니다.');
      title_input.focus();
      return;
    }

    if(document.querySelector('input[name="boardWriter"]').value == ''){
      alert('작성자는 필수입력입니다.')
      document.querySelector('input[name="boardWriter"]').focus();
      return;
    }

    axios
    .post('/writeForm',board)
    .then((res)=>{})
    .catch((error)=>{});
    navigate('/');
  }

  //강사님 풀이
  // function goJoin(){
  //   axios
  //   .post('/writeForm',board)
  //   .then((res)=>{
  //     alert('게시글이 등록되었습니다.')
  //     navigate('/');
  //   })
  //   .catch((error)=>{
  //     alert('글 등록 오류!!')
  //     console.log(error);
  //   });
  // }

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
      <button type='button' onClick={(e)=>{ goJoin() }}>글등록</button>
    </div>
  )
}

export default WriteForm