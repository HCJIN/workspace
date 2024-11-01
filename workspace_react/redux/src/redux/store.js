import { configureStore } from "@reduxjs/toolkit";
import { numReducer } from "./numState";
import { memberReducer } from "./memberState";

//모든 state 변수를 저장하는 저장소
const store = configureStore({
  reducer : {
    numState : numReducer,
    memberState : memberReducer
  }
});

export default store;