import React from "react";
import { Card, CardImg, CardBody, CardTitle, CardSubtitle, CardText, Button, Container, Row, Col} from "reactstrap";

const Concert = () => {
    const services = [
       
        {
            id: 1,
            name: "DJ or Band",
            description: "Make youre Event Joyful with our music.....",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCPpPCDJpnAEj_Zj82gqqmZ8a-Hww5KJWCnA&usqp=CAU",
            link: "/musicsystemui"
        },

        {
            id: 2,
            name: "Photography",
            description: "Capture the Precious Moments",
            image: "https://www.leisurebyte.com/wp-content/uploads/2021/01/photographer.jpg",
            link: "/photographyui"
        },

        {
            id: 3,
            name: "Firecrackers",
            description: "Any celebration is incomplete these...",
            image: "https://s.yimg.com/uu/api/res/1.2/PfyUv9xuSbSWpk7eXmsMAA--~B/aD0xMzM5O3c9MjIzNztzbT0xO2FwcGlkPXl0YWNoeW9u/http://media.zenfs.com/en_us/News/ap_webfeeds/12750c6ca6981716180f6a7067008aec.jpg",
            link: "/firecrackersui"
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
                <h1>              lets celebrate music...</h1>
            </div>
            <Row>
                {renderServices()}
            </Row>
        </Container>
    );
};

export default Concert;