//유효성 검사 결과를 저장할 변수
let resultArr = [
  false,
  false,
  false,
  false
];

let result_pw1 = false;
let result_pw2 = false;

//valid_tag[0] : memId
//valid_tag[1] : memName
export const joinValidate = (newData, valid_tag, tagName) => {

  //id값을 변경했으면 id 피드백만 띄움
  //pw값을 변경했으면 pw 피드백만 띄움
  //name값을 변경했으면 name 피드백만 띄움
  //tel값을 변경했으면 tel 피드백만 띄움

  //id가 영문만 포함 + 4~12자리인지 검사하는 정규식
  const regex_memId = /^[a-z|A-Z]{4,12}$/;
  //이름이 한글만 포함 + 2~10자리인지 검사하는 정규식
  const regex_memName = /^[가-힣]{2,10}$/;
  //비밀번호 및 비밀번호 확인 글자가 같아야함
  //4 ~ 12글자, 영문 소문자 + 숫자 조합
  const regex_memPw = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,12}$/
  // const regex_memPw = /^[a-z0-9]{4,12}$/
  //연락처 010-숫자4개-숫자4개
  const regex_memTel = /^010-\d{4}-\d{4}$/;

  switch(tagName){
    case 'memId' :
      //test() : 매개변수로 들어온 데이터가 조건에 부합하면 리턴 true
      //validation 처리
      if(regex_memId.test(newData.memId)){

        //div에 error 클래스 추가
        //div 태그 안에 글자변경 : 사용가능한 아이디입니다.
        sendFeedbackMsg(valid_tag[0], '사용가능한 아이디입니다.', 'good')
        resultArr[0] = true;
      }else{
        //div에 good 클래스 추가
        //div 태그 안에 글자 변경 : 아이디는 4~12글자 영문만 가능합니다.
        sendFeedbackMsg(valid_tag[0], '아이디는 4~12글자 영문이어야 합니다.', 'error')
        resultArr[0] = false;
      }
      break;
    case 'memPw' : 
    case 'confirmPw' :
      if(regex_memPw.test(newData.memPw)){
        sendFeedbackMsg(valid_tag[1], '사용가능한 비밀번호 입니다.', 'good');
        result_pw1 = true;
      }else{
        sendFeedbackMsg(valid_tag[1], '비밀번호는 영문 + 숫자 조합 4~12글자 입니다.', 'error')
        result_pw1 = false;
      }
      //입력한 두 비밀번호가 다르면
      if(newData.memPw != newData.confirmPw){
        sendFeedbackMsg(valid_tag[2], '비밀번호가 일치하지 않습니다.', 'error');
        result_pw2 = false;
      }else{
        sendFeedbackMsg(valid_tag[2],'비밀번호가 일치합니다.', 'good');
        result_pw2 = true;
      }

      resultArr[1] = result_pw1 && result_pw2 ? true : false;

      break;
    case 'memName' :
       // 이름 값 유효성 검사 정규식 충족하면
      if(regex_memName.test(newData.memName)){
        sendFeedbackMsg(valid_tag[3], '이름 맞습니다.', 'good')
        resultArr[2] = true;
      }else{
        sendFeedbackMsg(valid_tag[3], '이름은 2~10글자 한글이어야 합니다.', 'error')
        resultArr[2] = false;
      }
      break;
    case 'memTel' :
      if(regex_memTel.test(newData.memTel)){
        sendFeedbackMsg(valid_tag[4], '연락처가 맞습니다', 'good')
        resultArr[3] = true;
      }else{
        sendFeedbackMsg(valid_tag[4], '연락처는 010-0000-0000', 'error')
        resultArr[3] = false;
      }
      break;
  }

  //resultArr의 모든 데이터가 true일떄만 리턴 true

  //배열에 매개변수로 전달된 데이터가 존재하면 리턴 true
  return !resultArr.includes(false);

  for(const e of resultArr){
    if(!e){
      return false;
    }
  }

  return true;
}

//유효성 결과 메세지를 띄우는 함수
function sendFeedbackMsg(feedbackTag, msg, type){
  feedbackTag.current.className = `feedback ${type}`;
  feedbackTag.current.textContent = msg;
}