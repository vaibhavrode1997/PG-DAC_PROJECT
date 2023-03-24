import { Navigate, useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { toast } from 'react-toastify'

const Book = () => {

    // let navigate=Navigate();
    ///getting id of selected ucaterer for bill 
    let params = useParams();
    let id1 = params.id;
    let servicetype1 = params.servicetype;
    console.log(id1)
    console.log(servicetype1)

    //retrive user for order details
    let user = localStorage.getItem("user");
    let user1 = JSON.parse(user)
    console.log(user1.email)

    //usestate for datetime table
    const [data, setData] = useState({
        enddate: " ",
        endtime: " ",
        startdate: " ",
        starttime: " ",
    })
    //use effect 
    useEffect(() => {
        console.log(data);
    }, [data])

    //handle change
    const handleChange = (event, property) => {
        //dynamic stting the values
        setData({ ...data, [property]: event.target.value })
    }

    let str = "http://localhost:8181/api/" + servicetype1 + "/" + servicetype1 + "s"
    console.log(str)
    let rate;
    let amt;
    let tlamt;
    //onsubmit function
    const submitForm = (event) => {
        event.preventDefault();
        console.log("in submit form");

        //datetime object
        let datatobesend = {
            "enddate": data.enddate,
            "endtime": data.endtime,
            "startdate": data.startdate,
            "starttime": data.starttime,
        }


        //axios call for slot booking
        axios.post("http://localhost:8181/api/dateTime/dateTimes", datatobesend)
            .then((response) => {
                console.log(response.data);
                localStorage.setItem("datetime", JSON.stringify(response.data));
                let d = localStorage.getItem("datetime");
                let d1 = JSON.parse(d);
                toast.success("Congrats Date Time slot Booked...");


                //order body
                let orderdetails = {
                    "email": user1.email,
                    "status": "pending",
                    "datetime": {
                        "datetimeid": d1.dateandtimeid
                    },
                    "servicetype": servicetype1
                }
                //axios call for order placing
                axios.post("http://localhost:8181/api/order/orders", orderdetails)
                    .then((response) => {
                        console.log(response.data);
                    })
                    .catch((error) => {
                        console.log(error);
                    })
            })
            .catch((error) => {
                console.log(error)
            })

        let str1 = servicetype1 + "id"
        console.log(str1)
        // for fetching services from data base
        axios.get(str)
            .then((response) => {
                console.log(response.data);
                rate = response.data.map((val) => {

                    if (val.catererid == id1) {
                        return val.rate;
                    }
                })
                console.log(rate)


                // navigate("/bill")
                // amt = rate;
                // tlamt = (rate * 2 * + rate);
                // console.log(amt)
                // console.log(tlamt)

            })

        // const bill = () => {
        //     //preparing bill
        //     let billdetails = {
        //         "amount": amt,
        //         "tax": 2,
        //         "totalamount": tlamt,
        //         "user": {
        //             "userid": user1.userid
        //         },
        //     }
        //     axios.post("http://localhost:8181/api/bill/bills", billdetails)
        //         .then((response) => {
        //             console.log(response.data)
        //             //localStorage.setItem("orders", JSON.stringify(response))
        //             toast.success("bill generated....")

        //         })
        //         .catch((error) => {
        //             console.log(error)
        //         })
        }

    // }

    return (
        <div>
            <div class="row">
                <div class="mx-auto col-10 col-md-8 col-lg-6">

                    <form class="form-example" onSubmit={submitForm}>
                        <h1>Confirm DateTime Slot</h1>
                        <p class="description">
                            book service for youre preference wise
                        </p>
                        <div class="form-group">
                            <label for="startdate">StartDate :</label>
                            <input
                                type="date"
                                class="form-control startdate"
                                id="startdate"
                                name="startdate"
                                onChange={(e) => handleChange(e, 'startdate')}
                            />
                        </div>
                        <div class="form-group">
                            <label for="enddate">EndDate:</label>
                            <input
                                type="date"
                                class="form-control enddate"
                                id="enddate"
                                placeholder="enddate..."
                                name="enddate"
                                onChange={(e) => handleChange(e, 'enddate')}
                            />
                        </div>
                        <div class="form-group">
                            <label for="starttime">StartTime:</label>
                            <input
                                type="time"
                                class="form-control starttime"
                                id="starttime"
                                placeholder="starttime..."
                                name="starttime"
                                onChange={(e) => handleChange(e, 'starttime')}
                            />
                        </div>
                        <div class="form-group">
                            <label for="endtime">EndTime:</label>
                            <input
                                type="time"
                                class="form-control endtime"
                                id="endtime"
                                placeholder="endtime..."
                                name="endtime"
                                onChange={(e) => handleChange(e, 'endtime')}
                            />
                        </div>

                        <button type="submit" class="btn btn-primary btn-customized mt-4">Confirm</button>
                    </form>
                    <Link to={"/users/user"}><button class="btn btn-primary btn-customized mt-4">select more services</button></Link>
                    <Link to={`vieworder/${id1}`}><button class="btn btn-primary btn-customized mt-4">view order</button></Link>
                </div>
            </div>
        </div>
    )
}
export default Book;


