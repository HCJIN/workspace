import axios from 'axios';
import '../../css/cart.css';
import React, { useEffect, useState } from 'react';

const CartList = () => {

  //장바구니 목록 저장용 state
  const [cartList, setCartList] = useState([]);
  // console.log(cartList)

  //총 금액 계산 state
  const [totalPrice, setTotalPrice] = useState(0);
  // console.log(totalPrice)

  //체크된 아이템을 담을 배열
  const [checkItems, setCheckItems] = useState([]);
  //제목줄 체크박스의 체크여부를 저장하고 있는 state 변수
  //체크 : true 
  const [allChecked, setAllChecked] = useState(true)
  // console.log(checkItems)

  //선택삭제에 들어갈 cartCode를 담을 배열
  const selectedCartCodes = [];
  console.log(selectedCartCodes)

  const memId = JSON.parse(window.sessionStorage.getItem("loginInfo")).memId;

  // 장바구니 목록과 총 가격 계산
  const fetchCartList = () => {
    axios
      .get(`/cart/getCartList/${memId}`)
      .then((res) => {
        const carts = res.data;
        setCartList(carts);
        calculateTotalPrice();
        // 전체 선택 상태를 설정
        // if (carts.length > 0) {
        //   setCheckItems(carts.map((_, index) => index));
        //   setAllChecked(true);
        // } else {
        //   setCheckItems([]);
        //   setAllChecked(false);
        // }

        //조회된 장바구니 목록만큼 체크박스의 값을 설정
        let checkArr = new Array(res.data.length);
        checkArr.fill(true);
        setCheckItems(checkArr)

      })
      .catch((error) => {
        console.log(error);
      });
  };

  // 장바구니 목록 처음 로드
  useEffect(() => {
    fetchCartList();
  }, []);
  
  //체크된 아이템이 변경될 때마다 총 가격을 업데이트
  useEffect(()=>{
    calculateTotalPrice();
  },[checkItems])

  // 체크박스 단일 선택
  // const handleSingleCheck = (checked, index) => {
  //   if(checked) {
  //     //단일 선택 시 체크된 아이템을 배열에 추가
  //     setCheckItems([...checkItems, index]);
  //   }else{
  //     //단일 선택 해제 시 체크된 아이템을 제외한 배열 (필터)
  //     setCheckItems(checkItems.filter((el) => el !== index));
  //   }
  // }

  // 체크박스 전체 선택/해제
  // const handleAllCheck = (checked) =>{
  //   if(checked){
  //     const allIndexes = cartList.map((_,index) => index);
  //     setCheckItems(allIndexes)
  //   }else{
  //     setCheckItems([]);
  //   }
  //   setAllChecked(checked)
  // }

  // 총 가격 계산 함수
  // const calculateTotalPrice = () => {
  //   let total = 0;

  //   checkItems.forEach((index) => {
  //     const cart = cartList[index]
  //     total += cart.cartCnt * cart.item.itemPrice;
  //   });
  //   setTotalPrice(total);
  // };

  // 총 가격 계산 함수
  const calculateTotalPrice = () => {
    let total = 0;

    checkItems.forEach((isChecked, index) => {
      if (isChecked && cartList[index]) {
        const cart = cartList[index];
        total += cart.cartCnt * cart.item.itemPrice;
      }
    });
    setTotalPrice(total);
  };

  //선택 삭제
  function selectDelete(){
    checkItems.forEach((isChecked, index)=>{
      if(isChecked && cartList[index]){
        const cartCode = cartList[index].cartCode
        selectedCartCodes.push(cartCode)
      }
    })
    console.log(selectedCartCodes)
  }


  // 이미지 URL을 처리하는 함수
  const getImageUrl = (index) => {
    return (
      cartList[index].imgList[0] ? `http://localhost:8080/upload/${cartList[index].imgList[0].attachedFileName}` : ''
    );
  };

  // 장바구니 업데이트
  function updateCart(e, index) {
    const updatedCartList = [...cartList];
    updatedCartList[index][e.target.name] = e.target.value;
    setCartList(updatedCartList);

    const updateItem = updatedCartList[index];

    axios
      .post(`/cart/updateCart`, {
        memId: memId,
        itemId: updateItem.item.itemId,
        cartCnt: updateItem.cartCnt,
        itemPrice: updateItem.item.itemPrice,
        cartCode: updateItem.cartCode,
      })
      .then(() => {
      })
      .catch((error) => {
        console.log(error);
      });
  }

  //삭제버튼 클릭시 delete 
  function goDelete(cateCode){
    axios
    .delete(`/cart/cartDelete/${cateCode}`)
    .then(()=>{
      fetchCartList();
    })
    .catch((error)=>{
      console.log(error)
    })  
  }

  useEffect(()=>{
    if(checkItems.length != 0){
      //제목줄이 체크 -> 전체체크박스 체크
      const copyChks = [...checkItems];

      if(allChecked){
        copyChks.fill(true)
      }else{
        copyChks.fill(false)
      }
      setCheckItems(copyChks)
    }
  },[allChecked])

  //제목줄의 체크박스 변경 시 실행되는 함수
  function changeChkAll(){
    setAllChecked(!allChecked)
  }

  return (
    <div className='cartList-div'>
      <p className='cart-title'>
        <i className="bi bi-cart4" ></i>
        나의 장바구니
      </p>
      <table className='cartList-table'>
        <colgroup>
          <col width='5%' />
          <col width='5%' />
          <col width='20%' />
          <col width='10%' />
          <col width='*' />
          <col width='10%' />
          <col width='10%' />
          <col width='10%' />
        </colgroup>
        <thead className='head'>
          <tr>
            <td>No</td>
            <td>
              {/* <input type='checkbox'  name='select-all' onChange={(e) =>{
                handleAllCheck(e.target.checked)
              }}
              checked={allChecked}
              /> */}
              <input 
                type='checkbox'  
                name='select-all' 
                onChange={() =>{changeChkAll()}}
              checked={allChecked}
              />
            </td>
            <td>상품 정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>구매가격</td>
            <td>구매일시</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          {cartList.map((cart, i) => {
            const price = cart.item.itemPrice.toLocaleString('ko-KR', {
              style: 'currency',
              currency: 'KRW',
            });
            const priceSum = cart.cartCnt * cart.item.itemPrice;

            return (
              <tr key={i}>
                <td>{cartList.length - i}</td>
                <td>
                  {/* <input type='checkbox' name={`select-${i}`} onChange={(e)=>{
                    handleSingleCheck(e.target.checked, i)}}
                    checked={checkItems.includes(i)} //개별 선택 상태를 반영  
                  /> */}
                  <input 
                    type='checkbox' 
                    onChange={()=>{
                      const copyChks = [...checkItems]
                      copyChks[i] = !copyChks[i];
                      setCheckItems(copyChks)
                    }}
                    checked={checkItems[i]} //개별 선택 상태를 반영  
                  />
                </td>
                <td>
                  <div>
                    <img className='cartImg' src={getImageUrl(i)} alt='상품 이미지' />
                    <p>{cart.item.itemName}</p>
                  </div>
                </td>
                <td>{price}</td>
                <td>
                  <input
                    type='number'
                    name='cartCnt'
                    min={1}
                    max={10}
                    value={cart.cartCnt}
                    onChange={(e) => updateCart(e, i)}
                  />
                </td>
                <td>
                  {priceSum.toLocaleString('ko-KR', {
                    style: 'currency',
                    currency: 'KRW',
                  })}
                </td>
                <td>{cart.cartDate}</td>
                <td>
                  <button type='button' className='btn btn-primary' onClick={()=>{
                    goDelete(cart.cartCode)
                  }}>삭제</button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
      <div>
        <div className='total-div'>
          <p>
            총 구매금액 {totalPrice.toLocaleString('ko-KR', {
              style: 'currency',
              currency: 'KRW',
            })}
          </p>
        </div>
      </div>
      <div className='btn-div cart-btn'>
        <button type='button' className='btn btn-primary' onClick={()=>{
          selectDelete()
        }}>선택삭제</button>
        <button type='button' className='btn btn-primary'>선택구매</button>
      </div>
    </div>
  );
};

export default CartList;
