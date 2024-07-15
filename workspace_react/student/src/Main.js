import React from 'react'
import { useNavigate } from 'react-router-dom'

const Main = ({list,setList}) => {
  console.log(list)

  const navigate = useNavigate();

  return (
    <div className='table-div'>
      <table className='list-table'>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>국어점수</td>
            <td>영어점수</td>
            <td>수학점수</td>
            <td>평균</td>
          </tr>
        </thead>
        <tbody>
          {
            list.map((e, i) => {
              return(
                <tr key={i}>
                  <td>{e.stuNum}</td>
                  <td onClick={()=>{
                    navigate(`/detail/${e.stuNum}`)
                  }}>{e.stuName}</td>
                  <td>{e.koScore}</td>
                  <td>{e.enScore}</td>
                  <td>{e.mathScore}</td>
                  <td>{e.avg}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default Main