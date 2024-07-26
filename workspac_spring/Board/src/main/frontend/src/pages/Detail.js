import axios from 'axios';
import React, { useEffect, useState } from 'react'
import {getBoardList} from '../apis/boardApi'
import { useNavigate, useParams } from 'react-router-dom';
import * as replyApi from '../apis/reply'

const Detail = () => {


  const navigate = useNavigate();
  const [board, setBoard] = useState({})
  const {boardNum} = useParams();
  const [loginInfo, setLoginInfo] = useState({});
  const [replyList, setReplyList] = useState([]);
  const [rp, setRp] = useState({});
  const [show, setShow] = useState(false);
  const [cnt, setCnt] = useState(0);

  //선택한 게시글 데이터 가져오기
  // useEffect(()=>{
  //   axios.get(`/board/detail/${boardNum}`)
  //   .then((res)=>{
  //     setBoard(res.data)
  //   })
  //   .catch((error)=>{
  //     console.log(error)
  //   })
  // },[])

  //댓글 가져오기
  // useEffect(()=>{
  //   replyApi.getReplyList(boardNum)
  //   .then((res)=>{
  //     setReplyList(res.data)
  //   })
  //   .catch((error)=>{
  //     console.log(error)
  //   })
  // },[])

  useEffect(()=>{
    //로그인 여부 확인, 데이터 없으면 null 나옴
    const loginData = window.sessionStorage.getItem('loginInfo');

    //로그인 정보가 있으면...
    if(loginData != null){
      const result = JSON.parse(loginData);//json을 객체로 변환 
      setLoginInfo(result);//객체로 변환된 로그인 정보를 loginInfo 변수에 저장
    }
  },[])

  //리스트랑 가져온 값이랑 id 비교
  let toggle = false;
    if(loginInfo.memId == board.memId){
      toggle = true;
    }

  const goDelete = (boardNum) => {
    axios
    .delete(`/board/delete/${boardNum}`)
    .then((res)=>{
      // boardList.forEach((b,i)=>{
      //   if(b.boardNum == boardNum){
      //     boardList.splice(i,1)
      //   }
      // })
      navigate('/')
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  function goReply(){
    setShow(true)
  }

  function onRep(e){
    setRp({
      ...rp,
      memId : loginInfo.memId,
      boardNum : board.boardNum,
      [e.target.name] : e.target.value
    })
  }
  
  function onReply(){
    axios
    .post(`/reply/insert`, rp)
    .then((res)=>{
      setShow(false);
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  function goReplyDelete(replyNum){
    axios
    .delete(`/reply/delete/${replyNum}`)
    .then((res)=>{
      setCnt(cnt +1)
    })
    .catch((error)=>{
      console.log(error)
    })
  }


  //db에서 데이터 조회 여러개 동시에 실행하기
  useEffect(()=>{
    axios.all([axios.get(`/board/detail/${boardNum}`), 
              replyApi.getReplyList(boardNum)
              ])
    .then(axios.spread((res1, res2)=>{
      setBoard(res1.data)
      setReplyList(res2.data)
    }))
    .catch((error)=>{
      console.log(error)
    })
  },[show,cnt])

  return (
    <div className='detail-div'>
      <table className='detail-table'>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{board.createDate}</td>
            <td>작성자</td>
            <td>{board.memId}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}>{board.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>{board.content}</td>
          </tr>
        </tbody>
      </table>
      <div className='footer-div'>
        {
          loginInfo.memRole != 'admin' && toggle == false ?
          <>
            <button type='button' onClick={()=>{navigate('/')}}>목록가기</button>
          </> :
          <>
            <button type='button' onClick={()=>{navigate('/')}}>목록가기</button>
            <button type='button' onClick={()=>{navigate(`/update/${board.boardNum}`)}}>수정</button>
            <button type='button' onClick={()=>{goDelete(board.boardNum)}}>삭제</button>
            <button type='button' id='reply' onClick={()=>{goReply()}}>댓글입력</button>
          </>
        }
      </div>
      <div className='reply'>
        <div className='replyBoard'>
          {
            show == true ? 
              <table className='reply-in'>
              <tbody>
                <tr>
                  <td id="rp">댓글내용</td>
                  <td>
                    <input type='text' id='replyInput' name='replyContent' onChange={(e)=>{
                      onRep(e)
                    }}></input>
                  </td>
                  <td>
                    <button type='button' id='replyIn' onClick={()=>{
                      onReply()
                    }}>작성</button>
                  </td>
                </tr>
              </tbody>
            </table> :
            <div></div>
          }
        </div>
        <div className='reply-table'>
          {
            replyList.map((reply, i)=>{
              return(
                <div key={i}>
                  <p>{reply.replyDate} <span onClick={()=>{
                    goReplyDelete(reply.replyNum)
                  }}> 삭제 </span></p>
                  <p>{reply.memId}</p>
                  <p>{reply.replyContent}</p>
                </div>
              )
            })
          }
        </div>
      </div>
    </div>
  )
}

export default Detail