import { useNavigate } from 'react-router-dom'
import './App.css'

const Main = ({board_list}) => {

  const navigate = useNavigate();


  console.log(board_list)
  return(
    <div className="board_list">
      <table>
        <colgroup>
          <col width='15%'></col>
          <col width='*'></col>
          <col width='15%'></col>
          <col width='15%'></col>
        </colgroup>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {board_list.map((e,i)=>{
            return(
              <tr key={i}>
                <td>{e.boardNum}</td>
                <td onClick={(ele)=>{
                  navigate(`/detail/${e.boardNum}`)
                }}>{e.title}</td>
                <td>{e.writer}</td>
                <td>{e.createDate}</td>
              </tr>
            )
          })}
        </tbody>
      </table>

      <button type="button" onClick={()=>{
        navigate('/write_form');
      }}>글쓰기</button>
    </div>
  )
}

export default Main;