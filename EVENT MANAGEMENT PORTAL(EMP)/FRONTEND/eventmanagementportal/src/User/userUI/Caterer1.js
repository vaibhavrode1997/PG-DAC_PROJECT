import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Caterer1 = () => {

  // const serviceprovider = localStorage.getItem("service")
  // console.log(serviceprovider);

  const [data, setData] = useState([])
  //axios call for fetching data in database
  useEffect(() => {

    axios.get("http://localhost:8181/api/caterer/caterers")
      .then((response) => {
        setData(response.data);
        localStorage.setItem("caterer", JSON.stringify(response.data))
        console.log(response.data)
      })
  }, []);


  return (
    <div className="card1">
      <h1>in caterers</h1>
      <ol>
        {
          data.map((val) => (
            <li key={val.catererid}>
              <p>
                <div className="price1">
                  <h4>Caterers name  :  {val.name}</h4>
                  <h4>Description : {val.description}</h4>
                  <h4>Capacity : {val.capacity}</h4>
                  <h4>item type : {val.item}</h4>
                  <h4>Rate per plate: {val.rate}</h4>
                </div>
                 <Link to={`/bookservice/${val.catererid}/${"caterer"}`}><button class="btn btn-primary btn-customized mt-4">Book now</button></Link>
              </p>
            </li>
          ))
        }
      </ol>
    </div>

  )
}
export default Caterer1;
