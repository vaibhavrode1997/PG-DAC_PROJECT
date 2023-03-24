
import { Button } from 'react-bootstrap';
import axios from 'axios';
import { Input, Label } from 'reactstrap';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';


const MusicSystem = () => {

  const service = localStorage.getItem("service");
  //convert parse the object
  const ob = JSON.parse(service)
  console.log(ob.serviceid)
  //usestate
  const [data1, setData1] = useState({

    musicsystemname: " ",
    rate: " ",
    description: " ",
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
      "musicsystemname": data1.musicsystemname,
      "rate": data1.rate,
      "description": data1.description,
      "service": {
        "serviceid": ob.serviceid
      }
    }

    //post axios call
    axios.post("http://localhost:8181/api/musicsystem/musicsystems", datatobesend)
      .then((response) => {

        console.log(response.data);
        localStorage.setItem("musicsystem", JSON.stringify(response.data));
        const service1 = localStorage.getItem("musicsystem");
        const ob2 = JSON.parse(service1)
        console.log(ob2);

        //service registered message for vendor
        toast.success("Your service has been registered!!!!");
      })
      .catch((error) => {
        console.log(error)
      })
  }

  //update musicsystem
  const updateService = (event) => {
    event.preventDefault();

    let datatobesend = {
      "musicsystemname": data1.musicsystemname,
      "rate": data1.rate,
      "description": data1.description
      }
    
      //axios call for update musicsystem
      axios.put("http://localhost:8181/api/musicsystem/musicsystems", datatobesend)
      .then((response) => {

        //console.log(response.data);
        localStorage.setItem("musicsystem", JSON.stringify(response.data));
        const service1 = localStorage.getItem("musicsystem");
        const ob2 = JSON.parse(service1)
        console.log(ob2);
        //service updated message for vendor
        toast.success("Your service updated successfully!!!!");
      })
      .catch((error) => {
        console.log(error)
      })
    
  }

  return (
    <div>
       <h3>Fill Your MusicSystem details:</h3>
      <form onSubmit={submitForm}>
        <div>
          <Label for="musicsystemname">Name : </Label>
          <Input
            type='text'
            placeholder='Enter musicsystem name here'
            id='musicsystemname'
            onChange={(e) => handleChange(e, 'musicsystemname')}    //listner to accept data
            //value={data1.servicename} 
          />
        </div>

        <div>
          <Label for="rate">Rate : </Label>
          <Input
            type='text'
            placeholder='Enter rate here'
            id='rate'
            onChange={(e) => handleChange(e, 'rate')}    //listner to accept data 
           // value={data1.location}
          />
        </div>

        <div>
          <Label for="description">Description : </Label>
          <Input
            type='text'
            placeholder='Enter description here'
            id='description'
            onChange={(e) => handleChange(e, 'description')}    //listner to accept data 
            //value={data1.image}
          />
        </div>

        <div> 
        <pre><Button type='submit'>Register MusicSystem</Button>   <Button onClick={updateService}>Update MusicSystem</Button> </pre>
        </div>
      </form>
    </div>
  )
}
export default MusicSystem;