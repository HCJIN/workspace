import React, { useEffect, useState } from 'react';
import './Detail.css';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import Item from './Item';

const Detail = ({item}) => {

  //url로 전달되는 데이터 받기
  //1번 방식
  // const params = useParams();
  // console.log(params.id);

  //2번 방식 
  const {id} = useParams();
  // console.log(`전달된 상품번호 : ${id}`)

  const navigate = useNavigate();
  let findItem = null;

  item.forEach(element => {
    if(element.itemNum == id){
      findItem = element;
    }
  });

  const [num, setNum] = useState(0);
  const [num1, setNum1] = useState(0);



  //해당 컴포넌트가 랜더링되면 마지막에 실행
  // mount(컴포넌트를 새로 읽을 때) + update(재랜더링) 될때 실행
  // useEffect의 두번째 매개변수가 없으면 mount + update 될때 실행
  useEffect(() => {
    console.log(1)
  });

  // mount(컴포넌트를 새로 읽을 때 ) 될 때 실행
  //두번째 매개변수로 빈 배열을 전달하면 mount 될때만 실행
  useEffect(() => {
    console.log(2)
  }, []);

  //두번째 매개변수에 배열형태로 state 변수를 넣으면 
  //해당 useEffect는 mount + 배열에 넣은 state 값이 변경되어 재랜더링 될 때 실행
  useEffect(() => {
    console.log(3)
  }, [num]);

  useEffect(() => {
    console.log(4)
  }, [num, num1]);

  useEffect(() => {
    console.log(5)

    //return 안의 내용은 마운트 될 때 실행 x 
    //update 될때도 실행
    return () => {
      console.log(6);
    }
  }, [num]);

  //언마운트 될때 7 출력
  useEffect(() => {
    return () => {
      console.log(7)
    }
  },[]);

  return(
    <div className='detail_box'>
      <button type='button' onClick={(e)=>{
        setNum(num + 1);
      }}>num 값 변경!</button>
      <div> num = {num}</div>

      <button type='button' onClick={(e)=>{
        setNum1(num1 + 1);
      }}>num1 값 변경!</button>
      <div> num = {num1}</div>

      <div className="content_box">
        <img src={process.env.PUBLIC_URL + '/' + findItem.imgName}></img>
        <div className="con">
          <p>{findItem.itemName}</p>
          <p>{findItem.price}</p>
          <button type="button">주문하기</button>
        </div>
      </div>
      <div className="intro">
        <p>{findItem.intro}</p>
      </div>
      <button type='button' onClick={(e)=>{
        navigate('/list')
      }}>뒤로가기</button>
    </div>
  )
}

export default Detail;