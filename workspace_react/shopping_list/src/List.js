function List(props){
  return(
    <div className='list'>
      <p>장보기 목록</p>
      {props.list.map((item, i)=>{
        return(
          <div key={i}>
            <span>{item}</span>
            <button type='button' onClick={()=>{
              props.remove(i);
            }}>삭제</button>
          </div>
        );
      })}
    </div>
  );
}

export default List;