import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Update = () => {

  const navigate = useNavigate();
  const {boardNum} = useParams();
  const [board, setBoard] = useState({})

  useEffect(()=>{
    axios.get(`/board/detail/${boardNum}`)
    .then((res)=>{
      setBoard(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  function onChange(e){
    setBoard({
      ...board,
      [e.target.name] : e.target.value
    })
  }

  function goChange(boardNum){
    axios
    .post(`/board/update/${boardNum}`, board)
    .then((res)=>{
      navigate(`/detail/${boardNum}`)
      // navigate(`/`)
    })
    .catch((error)=>{

    })
  }

  return (
    <div className='update-div'>
      <table className='update-table'>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{board.createDate}</td>
            <td>작성자</td>
            <td>{board.memId}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}>
              <input type='text' id='title' name='title' value={board.title} onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>
              <input type='text' id='content' name='content' value={board.content} onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='footer-div'>
        <button type='button' onClick={()=>{
          goChange(board.boardNum)
        }}>수정</button>
      </div>
    </div>
  )
}

export default Update