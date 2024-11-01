import { createSlice } from "@reduxjs/toolkit";

//회원 정보 초기값 세팅
const initMember = {
  memId : '',
  memName : '',
  memAge : 0
}

//state의 값은 불변성을 유지 : state 기존의 값은 변하면 안 됨
const memberSlice = createSlice({
  name : 'member',
  initialState : initMember,
  reducers : {
    changeMemberInfo : (state, action) => {
      // state = action.payload;
      return action.payload;
    },
    changeMemberName : (state, action) => {
      state.memName = action.payload;
    }
  }
})

export const memberActions = memberSlice.actions;
export const memberReducer = memberSlice.reducer;