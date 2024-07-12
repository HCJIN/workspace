import { useState } from "react";

const InputTest = () => {
    // input 태그에 입력한 내용을 저장하는 변수
    const [inputData, setInputData] = useState('');
    const [inputData2, setInputData2] = useState('');

    const [stu, setStu] = useState({
      stuName : '',
      age : 0,
      score : 0,
      addr : ''
    });
    function changeStu(e){
      setStu({
        ...stu,
        [e.target.name] : e.target.value
      });
    }
  
    // inputData = 'asdsad';
    // setInputData(inputData); // inputData 변수의 값을 'java' 로 변경
  return(
    <div>
      <div>
        이름<input type='text' onChange={(e)=>{
          setInputData(e.target.value);
        }}></input>

        <br></br>
        
        나이<input type='text' onChange={(e)=>{
          setInputData2(e.target.value);
        }}></input>
      </div>
  
      <div>
        학생명 : <input type='text' name="stuName" onChange={(e) => {
          setStu({
            ...stu,
            stuName : e.target.value
          });
        }}></input> <br></br>
        나이 : <input type='text' name="age" onChange={(e)=>{
          changeStu(e);
        }}></input> <br></br>
        점수 : <input type='text' onChange={(e) => {
          setStu({
            ...stu,
            score : e.target.value
          })
        }}></input> <br></br>
        주소 : <input type='text' name='addr' onChange={(e)=>{
          changeStu(e);
        }}></input> <br></br>

        <div>
          이름  : {stu.stuName} <br></br>
          나이  : {stu.age} <br></br>
          점수  : {stu.score} <br></br>
          주소  : {stu.addr} <br></br>
        </div>
      </div>
    </div>
  )
}

export default InputTest;