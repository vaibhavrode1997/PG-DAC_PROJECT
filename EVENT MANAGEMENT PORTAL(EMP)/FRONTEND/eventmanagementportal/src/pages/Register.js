
import React, { useEffect, useState } from 'react';
import { register } from "../Services/user_service";
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from 'reactstrap';
import { toast } from 'react-toastify';

const Register = () => {

  // for saving user registration info state in react   data storing
  const [data, setData] = useState({

    firstname: '',
    lastname: '',
    email: '',
    contactnumber: '',
    password: '',
    reenterpassword: '',
    address: '',
    state: '',
    city: '',
    pincode: '',
    role: '',

  })

  // for handling errors make error state
  // const [error, setError] = useState({

  //   errors: {},
  //   isError: false
  // })

  //use effect 
  useEffect(() => {

    console.log(data);
  }, [data])

  //handle change
  const handleChange = (event, property) => {

    //dynamic stting the values
    setData({ ...data, [property]: event.target.value })

  }

  //reset form
  const resetData = () => {
    setData({
      firstname: '',
      lastname: '',
      email: '',
      contactnumber: '',
      password: '',
      reenterpassword: '',
      address: '',
      state: '',
      city: '',
      pincode: '',
      role: '',
    })
  }

  //submit form
  const submitForm = (event) => {
    event.preventDefault();

    console.log(data)
    //data validation

    //call server api for sending data
    register(data).then((response) => {
      console.log(response)
      console.log("sucsess")
      toast.success("registration done succsessfully")
      setData({
        firstname: '',
        lastname: '',
        email: '',
        contactnumber: '',
        password: '',
        reenterpassword: '',
        address: '',
        state: '',
        city: '',
        pincode: '',
        role: '',
      })
    }).catch((error) => {
      console.log(error)
      console.log("error")

    })
  }

  return (
    <div>
      <Container>
        <Row className='mt-4'>

          {/* {JSON.stringify(data)}  */}

          <Col sm={{ size: 8,offset:2}}>
            <Card color='dark' outline>
              <CardHeader>
                <h3>fill information for registration !!</h3>
              </CardHeader>
              <CardBody>
                {/* registration form */}
                <Form onSubmit={submitForm}>

                  {/* for firstname */}
                  <FormGroup>
                    <Label for="firstname"> Enter FirstName : </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='firstname'
                      onChange={(e) => handleChange(e, 'firstname')}    //listner to accept data from from
                      value={data.firstname}
                    />
                  </FormGroup>

                  {/* for lastname */}
                  <FormGroup>
                    <Label for="lastname"> Enter LastName : </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='lastname'
                      onChange={(e) => handleChange(e, 'lastname')}    //listner to accept data from from
                      value={data.lastname}
                    />
                  </FormGroup>

                  {/* for contactnumber */}
                  <FormGroup>
                    <Label for="contactnumber"> Enter ContactNumber: </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='contactnumber'
                      onChange={(e) => handleChange(e, 'contactnumber')}    //listner to accept data from from
                      value={data.contactnumber}
                    />
                  </FormGroup>

                  {/* for email */}
                  <FormGroup>
                    <Label for="email"> Enter Email : </Label>
                    <Input
                      type='email'
                      placeholder='Enter here'
                      id='email'
                      onChange={(e) => handleChange(e, 'email')}    //listner to accept data from from
                      value={data.email}
                    />
                  </FormGroup>

                  {/* for password */}
                  <FormGroup>
                    <Label for="password"> Set Password: </Label>
                    <Input
                      type='password'
                      placeholder='Enter here'
                      id='password'
                      onChange={(e) => handleChange(e, 'password')}    //listner to accept data from from
                      value={data.password}
                    />
                  </FormGroup>

                  {/* for re password */}
                  <FormGroup>
                    <Label for="reenterpassword"> Enter Reenter-Password: </Label>
                    <Input
                      type='password'
                      placeholder='Enter here'
                      id='reenterpassword'
                      onChange={(e) => handleChange(e, 'reenterpassword')}    //listner to accept data from from
                      value={data.reenterpassword}
                    />
                  </FormGroup>

                  {/* for adress */}
                  <FormGroup>
                    <Label for="address"> Enter Adress: </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='address'
                      onChange={(e) => handleChange(e, 'address')}    //listner to accept data from from
                      value={data.address}
                    />
                  </FormGroup>

                  {/* for state */}
                  <FormGroup>
                    <Label for="state"> Enter State: </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='state'
                      onChange={(e) => handleChange(e, 'state')}    //listner to accept data from from
                      value={data.state}
                    />
                  </FormGroup>

                  {/* for city */}
                  <FormGroup>
                    <Label for="city"> Enter City: </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='city'
                      onChange={(e) => handleChange(e, 'city')}    //listner to accept data from from
                      value={data.city}
                    />
                  </FormGroup>

                  {/* for pincode */}
                  <FormGroup>
                    <Label for="pincode"> Enter PinCode: </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='pincode'
                      onChange={(e) => handleChange(e, 'pincode')}    //listner to accept data from from
                      value={data.pincode}
                    />
                  </FormGroup>

                  {/* for role */}
                  <FormGroup>
                    {/* <Label for="role"> Select Role: </Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='role'
                      onChange={(e) => handleChange(e, 'role')}    //listner to accept data from from
                      value={data.role}
                    /> */}
                  <Label for="role">Select Role:</Label>
              <select id="role" name="role" onChange={(e) => handleChange(e, 'role')}>
                   <option value="select">select</option>
                   <option value="user">User</option>
                   <option value="vendor">Vendor</option>
             </select>
                  </FormGroup>

                  {/* submit buttons */}
                  <Container className='text-center'>
                    <Button color='dark'>Register</Button>
                    <Button onClick={resetData} color='secondary' type='reset' className='ms-2'>Reset</Button>
                  </Container>

                </Form>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  )
}
export default Register;