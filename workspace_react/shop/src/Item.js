import ItemList from "./ItemList";

const Item = ({item}) => {
  return(
    <div className="content">
      <img src={process.env.PUBLIC_URL + '/' + item.imgName}></img>
      <h3>{item.itemName}</h3>
      <p>{item.price}</p>
    </div>
  )
}

export default Item;