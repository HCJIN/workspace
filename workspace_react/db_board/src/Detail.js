import React from 'react'
import { useParams } from 'react-router-dom'

const Detail = ({boardList, setBoardList}) => {

  const {boardNum} = useParams();

  let board = null;
  boardList.forEach(element => {
    if(element.boardNum == boardNum){
      board = element;
    }
  });


  return (
    <div>
      {board.boardNum}
    </div>
  )
}

export default Detail