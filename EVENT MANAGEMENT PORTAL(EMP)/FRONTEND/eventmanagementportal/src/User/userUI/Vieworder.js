import axios from "axios";
import { useEffect, useState } from "react";

const Vieworder = () => {

    //get user oject to show his order
    let user = localStorage.getItem("user")
    let user1 = JSON.parse(user)
    console.log(user1);

    let service = localStorage.getItem("service")
    let service1 = JSON.parse(service)
    console.log(service1);
   

    let d = localStorage.getItem("datetime");
    let d1 = JSON.parse(d)
    console.log(d1);

    const [data, setData] = useState([])
    //axios call for fetching data in database
    useEffect(() => {
             axios.get("http://localhost:8181/api/order/orders")
            .then((response) => {
                setData(response.data);
                localStorage.setItem("orders", JSON.stringify(response))
                console.log(response.data)
            })
    }, []);

    
    
    const x = data.map((ord) => {

        if (ord.email == user1.email) {
            console.log(ord.email);
            return ord;
        }


    })
    // let order = x.firstname
    console.log(x);
    // //console.log(order.ordernumber);


    return (
        <div>
            <h4>username:{user1.firstname} {user1.lastname}</h4>
            <h4>email:{user1.email}</h4>
            <ol>
                {
                    x.map((val) => (
                        <li key={val.catererid}>
                            <p>
                                <div className="price1">
                                    <h4> servicetype:{val.servicetype}    <h5>ordernumber:{val.ordernumber}</h5></h4>
                                </div>
                            </p>
                        </li>
                    ))
                }
            </ol>
        </div>
    )
}
export default Vieworder;