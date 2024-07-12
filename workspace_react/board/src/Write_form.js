import React, { useState } from 'react'
import './write_form.css'
import './App.css'
import { useNavigate } from 'react-router-dom';

const Write_form = ({board_list,setBoard_list}) => {

  const navigate = useNavigate();

  // const newObj = {};

  // const goJoin = () => {
  //   const boardNum = document.querySelector('#boardNum').value;
  //   const title = document.querySelector('#title').value;
  //   const writer = document.querySelector('#writer').value;
  //   const createDate = document.querySelector('#createDate').value;
  //   const content = document.querySelector('#content').value;
  
  //   newObj.boardNum = Number(boardNum);
  //   newObj.title = title;
  //   newObj.content = content;
  //   newObj.writer = writer;
  //   newObj.createDate = createDate;

  //   board_list.push(newObj);
  //   navigate('/');
    
  // }

  const [item, setItem] = useState({
    boardNum : 0,
    title : '',
    content : '',
    writer : '',
    createDate : ''
  });

  function goItem(e){
    setItem({
      ...item,
      [e.target.name] : e.target.value
    })
  }

  function goJoin2(){
    // board_list.push(item);
    setBoard_list([...board_list,item])
    navigate('/');
  }



  return (
    <div className='container'>
      <table>
        <tbody>
          <tr>
            <td>글번호</td>
            <td>
              <input type='text' id='boardNum' name='boardNum' onChange={(e)=>{
                goItem(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>제목</td>
            <td>
              <input type='text' id='title' name='title' onChange={(e)=>{
                goItem(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>
              <input type='text' id='writer' name='writer' onChange={(e)=>{
                goItem(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>작성일</td>
            <td>
              <input type='date' id='createDate' name='createDate' onChange={(e)=>{
                goItem(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td>
              <textarea type='text' id='content' name='content' cols={50} rows={6} onChange={(e)=>{
                goItem(e);
              }}></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <button type='button' onClick={()=> {goJoin2()}}>글 등록</button>
    </div>
  )
}

export default Write_form