//item_list는 현재 쇼핑몰에서 판매하고 있는 상품들의 목록 정보이다.
//아래 데이터를 참고하여 요구사항을 해결하시오.
const item_list = [
  {
    item_name : '여름 셔츠',
    price : 25000,
    brand : 'java마켓',
    size : [90, 100, 110]
  },
  {
    item_name : '라운드 티',
    price : 20000,
    brand : 'java마켓',
    size : [90, 95, 100, 105, 110]
  },
  {
    item_name : '데님 청바지',
    price : 30000,
    brand : 'python마켓',
    size : [90, 100, 110, 120]
  },
  {
    item_name : '슬림 면바지',
    price : 35000,
    brand : 'python마켓',
    size : [90, 95, 100]
  }
];

//1. 'java마켓'에서 팔고 있는 상품들의 상품명과 가격을 각각 콘솔창에 출력하여라.

item_list.forEach((e)=>{
  if(e.brand == 'java마켓'){
    console.log(e.item_name);
    console.log(e.price);
  }
});

console.log('-----------------------');

//2. 95사이즈를 구매할 수 있는 상품들의 상품명을 콘솔창에 출력하시오.

item_list.forEach((e)=>{
  e.size.forEach((element)=>{
    if(element == 95){
      console.log(e.item_name);
    }  
  })
});

console.log('-----------------------');

//3. '등록 및 출력' 버튼을 클릭하면 입력 내용 저장 후 콘솔창에 데이터를 출력하시오.

function addItem(){
  
  const item = {};
  const arr = [];

  const itemName = document.querySelector('#itemName').value;
  const price = document.querySelector('#price').value;
  const brand = document.querySelector('#brand').value;
  const size = document.querySelectorAll('.size');
  
  if(itemName == ''){
    alert('상품명을 입력하세요')
  }else{
    item.item_name = itemName;
    item.price = Number(price);
    item.brand = brand;
    
    size.forEach((e)=>{
      if(e.checked){
        arr.push(Number(e.value));
      }
    });
    item.size = arr;

    item_list.push(item);

    console.log(item_list)
  }

  // 강사님 풀이

  const arr2 = [];
  const size2 = document.querySelectorAll('.size:checked');

  size2.forEach((e)=>{
    if(e.checked){
      arr2.push(e.value);
    }
  })


  const add_data = {

    item_name : document.querySelector('#itemName').value,
    price : document.querySelector('#price').value,
    brand : ocument.querySelector('#brand').value,
    size : arr2
  };

  item_list.push(add_data);






}

