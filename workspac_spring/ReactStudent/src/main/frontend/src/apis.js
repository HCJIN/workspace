//서버와 통신하는 기능을 모아놓은 js

import axios from "axios";


//학생 목록 조회 api
export const getStuList = () => {
  const reponse = axios.get('/getMain');
  return reponse;
} 

export const getDetail = (stuNum) => {
  const response = axios.get(`/detail/${stuNum}`);
  console.log(response)
  return response;
}