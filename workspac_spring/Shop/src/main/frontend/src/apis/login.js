import axios from "axios"

//아이디 비밀번호 체크 
export const checkIdPw = (id) => {
  const response  = axios.post(`/api_member/login`, id);
  return response;
}