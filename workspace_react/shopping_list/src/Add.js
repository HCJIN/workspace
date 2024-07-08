import { useState } from "react";

function Add(props){

  //input 태그의 데이터를 저장할 변수
  let [text, setText] = useState('');

  return(
    <div className='add'>
      <input type='text' className='input' onChange={(e)=>{
        setText(e.target.value);
      }}></input>
      <button type='button' id='addBtn' onClick={() => {
        // const content = document.querySelector('.input').value;
        // props.setList(list => [...list,content])

        //input 태그에 입력한 내용을 가져온다.
        //가져온 내용을 list에 추가한다. 
        props.list.push(text);
        console.log(props.list)
        //변경된 list의 내용으로 setList 함수를 호출  
        props.setList([...props.list]);
        

      }}>추가</button>
    </div>

  );
}

export default Add;