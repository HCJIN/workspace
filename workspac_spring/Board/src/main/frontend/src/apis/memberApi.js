import axios from "axios"

//아이디 중복 체크 
export const chekId = (data) => {
  const response = axios.get(`/member/checkId/${data}`);
  return response;
}

//아이디 비밀번호 체크
export const chekIdPw = (id) => {
  const response = axios.post(`/member/checkIdPw`, id);
  return response;
}

//회원가입 
export const join = (data) => {
  const response = axios.post('/member/join',data)
  return response;
}