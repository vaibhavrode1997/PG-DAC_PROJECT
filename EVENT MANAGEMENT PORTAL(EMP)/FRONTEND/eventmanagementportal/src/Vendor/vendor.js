
import { Button } from 'react-bootstrap';
import axios from 'axios';
import { Input, Label } from 'reactstrap';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

const Vendor = () => {

  const navigate = useNavigate();

  const user = localStorage.getItem("user");
  //convert parse the object
  const ob = JSON.parse(user)
  console.log(ob.userid)
  //usestate
  const [data1, setData1] = useState({

    servicename: " ",
    servicetype: " ",
    owner: " ",
    location: " ",
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
      "image": " ",
      "location": data1.location,
      "owner": data1.owner,
      "servicename": data1.servicename,
      "servicetype": data1.servicetype,
      "user": {
        "userid": ob.userid
      }
    }

    //post axios call

    axios.post("http://localhost:8181/api/service/services", datatobesend)
      .then((response) => {

        console.log(response.data);
        localStorage.setItem("service", JSON.stringify(response.data));
        const service1 = localStorage.getItem("service");
        const ob2 = JSON.parse(service1)
          console.log(ob2.servicetype);

        //check here service type ande redirecting control
        if (ob2.servicetype == "Hall") {
          navigate("/Hall");
        }
        else if (ob2.servicetype == "Caterer") {
          navigate("/Caterer");
        }
        else if (ob2.servicetype == "Decoration") {
          navigate("/Decoration");
        }
        else if (ob2.servicetype == "Firecrackers") {
          navigate("/Firecrackers");
        }
        else if (ob2.servicetype == "Horse") {
          navigate("/Horse");
        }
        else if (ob2.servicetype == "MusicSystem") {
          navigate("/MusicSystem");
        }
        else if (ob2.servicetype == "Photography") {
          navigate("/Photography");
        }
        else if (ob2.servicetype == "Poojavidhi") {
          navigate("/Poojavidhi");
        }
        else if (ob2.servicetype == "WaterSupply") {
          navigate("/WaterSupply");
        }
        else if (ob2.servicetype == "Transportation") {
          navigate("/Transportation");
        }
        else {
          toast.error("invalid servicetype")
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
      "image": " ",
      "location": data1.location,
      "owner": data1.owner,
      "servicename": data1.servicename,
      "servicetype": data1.servicetype
      }
    
      //axios call for update service
      axios.put("http://localhost:8181/api/service/services", datatobesend)
      .then((response) => {

        //console.log(response.data);
        localStorage.setItem("service", JSON.stringify(response.data));
        const service1 = localStorage.getItem("service");
        const ob2 = JSON.parse(service1)
      
        //check here service type ande redirecting control
        if (ob2.servicetype == "Hall") {
          navigate("/Hall");
        }
        else if (ob2.servicetype == "Caterer") {
          navigate("/Caterer");
        }
        else if (ob2.servicetype == "Decoration") {
          navigate("/Decoration");
        }
        else if (ob2.servicetype == "Firecrackers") {
          navigate("/Firecrackers");
        }
        else if (ob2.servicetype == "Horse") {
          navigate("/Horse");
        }
        else if (ob2.servicetype == "MusicSystem") {
          navigate("/MusicSystem");
        }
        else if (ob2.servicetype == "Photography") {
          navigate("/Photography");
        }
        else if (ob2.servicetype == "Poojavidhi") {
          navigate("/Poojavidhi");
        }
        else if (ob2.servicetype == "WaterSupply") {
          navigate("/WaterSupply");
        }
        else if (ob2.servicetype == "Transportation") {
          navigate("/Transportation");
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
      <h3>Fill Your Service details:</h3>
      <form onSubmit={submitForm}>
        <div>
          <Label for="servicename">ServiceName : </Label>
          <Input
            type='text'
            placeholder='Enter Servicename here'
            id='servicename'
            onChange={(e) => handleChange(e, 'servicename')}    //listner to accept data from from
            //value={data1.servicename} 
          />
        </div>

        <div>
          <Label for="servicetype">Select ServiceType:</Label>
          <select id="servicetype" name="servicetype" onChange={(e) => handleChange(e, 'servicetype')}>
            <option value="Hall">Hall</option>
            <option value="Caterer">Caterer</option>
            <option value="Decoration">Decoration</option>
            <option value="WaterSupply">Water Supply</option>
            <option value="MusicSystem">Music System</option>
            <option value="Horse">Horse</option>
            <option value="Transportation">Transportation</option>
            <option value="Poojavidhi">Poojavidhi</option>
            <option value="Firecrackers">Firecrackers</option>
            <option value="Photography">Photography</option>
          </select>

        </div>


        <div>
          <Label for="owner">Owner    : </Label>
          <Input
            type='text'
            placeholder='Enter Owner name here'
            id='owner'
            onChange={(e) => handleChange(e, 'owner')}    //listner to accept data from from
            //value={data1.owner}
          />
        </div>

        <div>
          <Label for="location">Location : </Label>
          <Input
            type='text'
            placeholder='Enter location here'
            id='location'
            onChange={(e) => handleChange(e, 'location')}    //listner to accept data from from
           // value={data1.location}
          />
        </div>

        <div>
          <Label for="image">Image : </Label>
          <Input
            type='image'
            placeholder='Add image'
            id='image'
            onChange={(e) => handleChange(e, 'image')}    //listner to accept data from from
            //value={data1.image}
          />
        </div>
        <div>
          <pre><Button type='submit'>Register Service</Button>   <Button onClick={updateService}>Update Sevice</Button></pre>
        </div>
      </form>
    </div>
  )
}
export default Vendor;