import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

//App() 함수의 리턴문 안에 작성하는 코드가 화면에 나타남.
//html 코드처럼 보이는 것은 실은 jsx 라는 문법니다.
//그렇기 때문에 html과 조금 다른 부분이 있다.
//useState로 만들어서 변수 값을 변경하면 html 화면을 재랜더링한다.
function App() {

  //제목 정보를 저장하고 있는 변수
  const [titles, setTitles] = useState(
    ['울산 맛집', 'React 공부', '졸리다']
  );

  //대괄호의 첫번째 : 변수
  //두번째 : 변수의 값을 변경시켜주는 함수
  //ex) setLikeCnt(5); -> likeCnt 변수의 값을 5로 변경
  let [likeCnt, setLikeCnt] = useState(
    [0,0,0]
  );

  //detail 컴포넌트가 보일지 안보일지 결정하는 변수
  let [isShow, setIsShow] = useState(false);

  const ti = () => {
    const copyTitles = [...titles];
    copyTitles[0] = '대구 맛집'
    copyTitles[2] = '잠온다'
    setTitles(copyTitles)
  }

  //function name(){}
  const name = () => {}

  // [1,2,3].forEach(function(){})
  [1,2,3].forEach((e, i) => {

  });

  return (
    <div className="App">
      <div className='blog-nav'>
        <h3>My Blog</h3>
      </div>

      {/* {
        [1,2,3].map((e,i)=>{
          return (
            <div key={i}>{e}</div>
          );
        })
      } */}

      <button type='button' onClick={ti}>제목변경</button>

      {/* 블로그 글 목록 */}
      <Board title={titles} setTitles={setTitles} cnt={likeCnt} setLikeCnt={setLikeCnt} ></Board>

      {/* 상세보기 */}
      {
        isShow ? <Detail/> : null
      }
      <Add title={titles} setTitles={setTitles} cnt={likeCnt} setLikeCnt={setLikeCnt}></Add>

    </div>
  );
}

//상세보기 컴포넌트
//컴포넌트의 리턴문에 html 작성
//모든 html 태그는 하나의 최상위 태그에 포함되게 작성
function Detail(){
  return(
    <div className='detail'>
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}

//블로그 글 하나에 대한 컴포넌트
function Board(props){
  
  let cnt = [...props.cnt];

  return(
    <div className='list'>
        {
          props.title.map((item, i)=>{
            return(
              <div key={i}>
                <span>{item}</span>
                <span onClick={()=>{
                  cnt[i] = cnt[i] + 1;
                  props.setLikeCnt(cnt);
                }}>👍</span>
                {props.cnt[i]}
                <button type='button' className='btn' onClick={()=>{
                  props.title.splice(i,1);
                  props.cnt.splice(i,1);
                  props.setTitles([...props.title])
                  props.setLikeCnt([...props.cnt])
                }}>삭제</button>
                <p>2024-07-04</p>
              </div>
            );
          })
        }
    </div>
  );
};

function Add(props){

  let [text, setText] = useState('');

  return(
    <div className='add'>
      <input type='text' className="input" onChange={(e) => {
        text = e.target.value;
        setText(text);
      }}></input>
      <button type='button' onClick={() => {
        props.title.push(text);
        props.setTitles([...props.title]);
        props.cnt.push(0);
        props.setLikeCnt([...props.cnt]);
      }}>추가</button>
    </div>


  );
}

//블로그 글 하나에 대한 컴포넌트
//함수명의 첫글자가 대문자면 컴포넌트를 의미함
//전달되는 데이터는 컴포넌트의 매개변수 props 라는 변수를 통해 전달 받음

export default App;
