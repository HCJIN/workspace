// === 게시판 테이블에서 사용하는 axios 모음 === //

import axios from "axios"

//게시글 목록 조회
export const getBoardList = (pageNo) => {
  const response = axios.post('/board/boardList',{'pageNo' : pageNo});
  return response;
}