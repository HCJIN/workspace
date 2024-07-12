import { useNavigate, useParams } from "react-router-dom"
import './detail.css'

const Detail = ({board_list,setBoard_list})=>{

  const navigate = useNavigate();

  const {id} = useParams();

  let board = null;
  board_list.forEach(element => {
    if(element.boardNum == id){
      board = element;
    }
  });

  function goDel(boardNum){
    const newData = [...board_list];
    for(let i = 0; i < newData.length; i++){
      if(newData[i].boardNum == boardNum){
        newData.splice(i, 1);
        break;
      }
    }
    setBoard_list(newData);
    navigate('/');
  }

  return(
    <div className="board_list">
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>{board.boardNum}</td>
            <td>작성자</td>
            <td>{board.writer}</td>
            <td>작성일</td>
            <td>{board.createDate}</td>
          </tr>
        </thead>
        <tbody>
          <tr className="content">
            <td>제목</td>
            <td colSpan={5}>{board.title}</td>
          </tr>
          <tr className="content">
            <td>내용</td>
            <td colSpan={5}>{board.content}</td>
          </tr>
        </tbody>
      </table>
      <div className="btn_box">
        <button type="button" onClick={()=>{
          navigate('/')
        }}>뒤로가기</button>
        <button type="button" onClick={() => goDel(board.boardNum)}>삭제</button>
      </div>
    </div>
  )
}


export default Detail;