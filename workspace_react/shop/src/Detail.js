import React from 'react';
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
  console.log(`전달된 상품번호 : ${id}`)

  const navigate = useNavigate();
  let findItem = null;

  item.forEach(element => {
    if(element.itemNum == id){
      findItem = element;
    }
  });


  return(
    <div className='detail_box'>
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