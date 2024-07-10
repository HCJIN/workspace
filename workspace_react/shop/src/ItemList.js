import Item from "./Item";


const ItemList = ({item_list}) => {
  return(
    <div className="img_box">
      {
        item_list.map((item, i)=>{
          return(
            <Item item={item} key={i}></Item>
          )
        })
      }
    </div>
  );
}

export default  ItemList;