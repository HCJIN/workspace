//state 변수 num의 초기값을 설정하고 
//num의 변수의 값을 변경하는 함수들을 정의

import { createSlice } from "@reduxjs/toolkit"

//num 변수에 저장할 초기값
const initNum = {
  value : 0
}

//Slice : state변수의 초기화 및 함수 생성
const numSlice = createSlice({
  //Slice를 구분하기 위한 id
  name : 'num',

  //state변수에 저장될 초기값
  initialState : initNum,

  //state 변수의 값을 변경하는 함수
  //첫번째 매개변수 : state변수가 가진 기존 값
  //두번째 매개변수 : state변수의 값을 변경할 데이터
  reducers : {
    addNum : (state) => {
      state.value = state.value + 1;
    },
    subNum : (state, action) => {
      state.value += -1;
    },
    resetNum : (state, action) => {
      state.value  = 0;
    },
    changeNum : (state, action) => {
      state.value = state.value + action.payload;
    }
  }
});

//numSlice.actions : numSlice에 정의된 함수들
export const numActions = numSlice.actions;

//numSlice 전체 내용
export const numReducer = numSlice.reducer;