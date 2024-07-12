import Detail from "./Detail";
import Item from "./Item";


const ItemList = ({item_list}) => {
  return(
    <div className="img_box">
      {
        item_list.map((item, i)=>{
          return(
            <div key={i}>
              <Item item={item}></Item>
            </div>
          )
        })
      }
    </div>
  );
}

export default  ItemList;