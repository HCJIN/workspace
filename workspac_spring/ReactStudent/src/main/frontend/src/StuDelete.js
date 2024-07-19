import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import {getStuList} from './apis'

const StuDelete = () => {

  const navigate = useNavigate();
  const [studentList, setStudentList] = useState([]);

  useEffect(()=>{
    getStuList()
    .then((res)=>{
      setStudentList(res.data);
    })
    .catch((error)=>{

    })
  },[])

  function goDel(stuNum){
    axios
    .delete(`/delete/${stuNum}`)
    .then((res)=>{
      //studentList라는 state 변수의 값을 변경한다 -> 재랜더링 되면서 알아서 그림 새롭게 그린다.
      studentList.forEach((stu,i)=>{
        if(stu.stuNum == stuNum){
          studentList.splice(i,1);
        }
      });

      // const result = studentList.filter((student)=>{student.stuNum != stuNum});

      const arr = [1,2,3,4,5,6,7,8];
      const result1 = arr.filter( (num) => {return num > 5});
      const result2 = arr.filter( (num) =>  num > 5);



      setStudentList([...studentList])
    })
    .catch((error)=>{

    })
  }

  return (
    <div className='table-div'>
      <table className='list-table'>
        <colgroup>
          <col width='33%'></col>
          <col width='33%'></col>
          <col width='33%'></col>
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>성적입력</td>
          </tr>
        </thead>
        <tbody>
          {
            studentList.map((student, i)=>{
              return(
                <tr key={i}>
                  <td>{i +1 }</td>
                  <td>{student.stuName}</td>
                  <td>
                    <button type='button' onClick={(e)=>{
                      goDel(student.stuNum)
                    }}>삭제</button>
                  </td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default StuDelete