import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const WaterSupply1 = () => {
  
  const [data, setData] = useState([])
  //axios call for fetching data in database
  useEffect(() => {

    axios.get("http://localhost:8181/api/watersupply/watersupplys")
      .then((response) => {
        setData(response.data);
        localStorage.setItem("watersupply", JSON.stringify(response.data))
        console.log(response.data)
      })
  }, []);

  return (
    <div className="card1">
      <ol>
        {
          data.map((val) => (
            <li key={val.watersupplyid}>
              <p>
                <div className="price1">
                  <h4>WaterSupply name : {val.name}</h4>
                  <h4>Rate : {val.rate}</h4>
                  <h4>quantity : {val.quantity}</h4>
                  <h4>Description : {val.description}</h4>
                </div>
                <Link to={`/bookservice/${val.watersupplyid}/${"watersupply"}`}><button class="btn btn-primary btn-customized mt-4">Book now</button></Link>
              </p>
            </li>
          ))
        }
      </ol>
    </div>
  )
}
export default WaterSupply1;