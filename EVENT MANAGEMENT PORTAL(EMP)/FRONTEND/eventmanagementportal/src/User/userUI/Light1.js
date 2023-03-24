import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Light1 = () => {
  
  const [data, setData] = useState([])
  //axios call for fetching data in database
  useEffect(() => {

    axios.get("http://localhost:8181/api/light/lights")
      .then((response) => {
        setData(response.data);
        localStorage.setItem("light", JSON.stringify(response.data))
        console.log(response.data)
      })
  }, []);

  return (
    <div className="card1">
      <ol>
        {
          data.map((val) => (
            <li key={val.flowerid}>
              <p>
                <div className="price1">
                  <h4>name  :  {val.name}</h4>
                  <h4>Rate :{val.rate}</h4>
                  <h4>Light Type : {val.type}</h4>
                  <h4>Description : {val.description}</h4>
                </div>
                <Link to={`/bookservice/${val.lightid}/${"light"}`}><button class="btn btn-primary btn-customized mt-4">Book now</button></Link>
              </p>
            </li>
          ))
        }
      </ol>
    </div>
  )
}
export default Light1;