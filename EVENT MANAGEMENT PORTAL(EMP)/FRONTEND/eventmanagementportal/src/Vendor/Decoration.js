
import { Button } from 'react-bootstrap';
import axios from 'axios';
import { Label } from 'reactstrap';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

const Decoration = () => {

  const navigate = useNavigate();

  const service = localStorage.getItem("service");
  //convert parse the object
  const ob = JSON.parse(service)
  console.log(ob.userid)
  //usestate
  const [data1, setData1] = useState({

    categorytype: " ",
   
  })

  //use effect 
  useEffect(() => {

    console.log(data1);
  }, [data1])

  //handle change
  const handleChange = (event, property) => {

    //dynamic stting the values
    setData1({ ...data1, [property]: event.target.value })

  }

  //submit form
  const submitForm = (event) => {
    event.preventDefault();

    console.log("in submit form")
    let datatobesend = {
      
      "categorytype": data1.categorytype,
      "service": {
        "serviceid": ob.serviceid
      }
    }

    //post axios call

    axios.post("http://localhost:8181/api/decoration/decorations", datatobesend)
      .then((response) => {

        console.log(response.data);
        localStorage.setItem("decoration", JSON.stringify(response.data));
        const service1 = localStorage.getItem("decoration");
        const ob2 = JSON.parse(service1)
        console.log(ob2);
          console.log(ob2.categorytype);

        //check here service type ande redirecting control
        if (ob2.categorytype == "Light") {
          navigate("/Light");
        }
        else if (ob2.categorytype == "Flower") {
          navigate("/Flower");
        }
        else if (ob2.categorytype == "Makeup") {
          navigate("/Makeup");
        }
        else {
          toast.error("invalid categorytype")
        }
      })
      .catch((error) => {
        console.log(error)
      })
  }

  //update Service
  const updateService = (event) => {
    event.preventDefault();

    let datatobesend = {
      "categorytype": data1.categorytype
      }
    
      //axios call for update service
      axios.put("http://localhost:8181/api/decoration/decorations", datatobesend)
      .then((response) => {

        //console.log(response.data);
        localStorage.setItem("decoration", JSON.stringify(response.data));
        const service1 = localStorage.getItem("decoration");
        const ob2 = JSON.parse(service1)
      
        //check here service type ande redirecting control
        if (ob2.servicetype == "Light") {
          navigate("/Light");
        }
        else if (ob2.servicetype == "Flower") {
          navigate("/Flower");
        }
        else if (ob2.servicetype == "Makeup") {
          navigate("/Makeup");
        }
        else {
          toast.error("invalid servicetype")
        }
      })
      .catch((error) => {
        console.log(error)
      })
  }

  return (
    <div>
       <h3>Select CategoryType:</h3>
      <form onSubmit={submitForm}>
        <div>
          <Label for="categorytype">Category Type:</Label>
          <select id="categorytype" name="categorytype" onChange={(e) => handleChange(e, 'categorytype')}>
            <option value="Light">Light</option>
            <option value="Flower">Flower</option>
            <option value="Makeup">Makeup</option>
          </select>
        </div>

        <div>
          <pre><Button type='submit'>Register Decoration</Button>   <Button onClick={updateService}>Update Decoration</Button></pre>
        </div>
      </form>
    </div>
  )
}
export default Decoration;