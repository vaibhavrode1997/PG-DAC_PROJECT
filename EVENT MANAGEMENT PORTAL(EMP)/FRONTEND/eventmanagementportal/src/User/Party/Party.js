import React from "react";
import { Card, CardImg, CardBody, CardTitle, CardSubtitle, Button, Container, Row, Col, Pagination, PaginationItem, PaginationLink } from "reactstrap";

const Party = () => {
    const services = [
        {
            id: 1,
            name: "Catering",
            description: "Explore Delicious Food at your fingertip...",
            image: "https://i.pinimg.com/originals/90/6e/79/906e793f78a72be2be037234e9763d9d.jpg",
            link: "/catererui"
        },
        {
            id: 2,
            name: "DJ or Band",
            description: "Make youre Event Joyful with our music.....",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCPpPCDJpnAEj_Zj82gqqmZ8a-Hww5KJWCnA&usqp=CAU",
            link: "/musicsystemui"
        },

        {
            id: 3,
            name: "Photography",
            description: "Capture the Precious Moments",
            image: "https://www.leisurebyte.com/wp-content/uploads/2021/01/photographer.jpg",
            link: "/photographyui"
        },
        {
            id: 4,
            name: "WaterSupply",
            description: "Water is life and we require it at events to provide it to number of guests...",
            image: "https://english.cdn.zeenews.com/sites/default/files/2020/04/15/854918-drinking-water.gif",
            link: "/watersupplyui"
        },
        
        {
            id: 5,
            name: "Flower",
            description: "Flowers Services...",
            image: "https://i.pinimg.com/originals/48/4c/b0/484cb019d737393b4f8be03da93f0319.jpg",
            link: "/flowerui"
          },

          {
            id: 6,
            name: "Light",
            description: "Lighting is necessary to make events special...",
            image: "https://mdmentertainment.com/wp-content/uploads/2019/07/chicago-Social-Event-Lighting-Service-1024x684.jpeg",
            link: "/lightui"
          },

        // add more services here
    ];


    // get the services for the current page
    const getPageServices = () => {
        const startIndex = 0;
        const endIndex = startIndex + 6;
        return services.slice(startIndex, endIndex);
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
                <h1>              Party Services</h1>
            </div>
            <Row>
                {renderServices()}
            </Row>
        </Container>
    );
};

export default Party;