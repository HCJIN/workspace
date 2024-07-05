import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const board_list = [
    {
      boardNum : 1,
      title : '첫번째 게시글',
      content : '첫번째 내용',
      writer : '김자바'
    },
    {
      boardNum : 2,
      title : '두번째 게시글',
      content : '두번째 내용',
      writer : '이자바'
    },
    {
      boardNum : 3,
      title : '세번째 게시글',
      content : '세번째 내용',
      writer : '박자바'
    }
  ];  

  let [isShow, setIsShow] = useState(false);

  const [index, setIndex] = useState(0);



  return (
    <div className="App">
      <div className='container'>
        <table className='list-table'>
          <thead>
            <tr>
              <td>글번호</td>
              <td>제목</td>
              <td>작성자</td>
            </tr>
          </thead>
          <tbody>
              {
                board_list.map((e, index)=>{
                    return(
                      <tr key={index}>
                        <td>{e.boardNum}</td>
                        <td >
                          <span onClick={()=>{
                              setIsShow(!isShow)
                              setIndex(index);
                            }}>{e.title}
                          </span>
                        </td>
                        <td>{e.writer}</td>
                      </tr>
                    );
                })
              }
          </tbody>
        </table>
      </div>
      {/* 상세보기 */}
      {
        isShow ? <Detail board={board_list[index]}/> : null
      }
    </div>
  );
}

function Detail(props){
  console.log(props)
  return(
  <div className='detail'>
    <div>글번호 :{props.board.boardNum}</div>
    <div>제목 : {props.board.title}</div>
    <div>내용 : {props.board.content}</div>
    <div>작성자 : {props.board.writer}</div>
  </div>
  );
}


export default App;
