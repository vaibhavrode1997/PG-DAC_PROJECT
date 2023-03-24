import React from "react";
import { Card, CardImg, CardBody, CardTitle, CardSubtitle, CardText, Button, Container, Row, Col, } from "reactstrap";

const Decoration1 = () => {

  const service = [

    {
      id: 1,
      name: "Flower",
      description: "Flowers Services...",
      image: "https://i.pinimg.com/originals/48/4c/b0/484cb019d737393b4f8be03da93f0319.jpg",
      link: "/flowerui"
    },
    {
      id: 2,
      name: "Light",
      description: "Lighting is necessary to make events special...",
      image: "https://mdmentertainment.com/wp-content/uploads/2019/07/chicago-Social-Event-Lighting-Service-1024x684.jpeg",
      link: "/lightui"
    },
    {
      id: 3,
      name: "Makeup",
      description: "Every girls needs to look her best in events..",
      image: "https://tse1.mm.bing.net/th?id=OIP.bUcGuPiypdyFTtWole68UQHaE8&pid=Api",
      link: "/makeupui"
    },
  ];

  // get the services for the current page
  const getPageServices = () => {
    const startIndex = 0;
    const endIndex = startIndex + 3;
    return service.slice(startIndex, endIndex);
  };

   // render the services for the current page
   const renderServices = () => {
    return getPageServices().map((service) => (
      <Col key={service.id} lg={4} md={6} className="mb-4">
        <Card>
          <CardImg top width="100%" src={service.image} alt={service.name} />
          <CardBody>
            <CardTitle tag="h5">{service.name}</CardTitle>
            <CardSubtitle tag="h6" className="mb-2 text-muted">{service.description}</CardSubtitle>
            <Button color="primary" href={service.link}>View Service</Button>
          </CardBody>
        </Card>
      </Col>
    ));
  };

  return (
    <Container>
      <div>
        <p>
        <h1>Make your Event lightning.....</h1>
        </p>
       
      </div>
      <Row>
        {renderServices()}
      </Row>
    </Container>
  )
}
export default Decoration1;
