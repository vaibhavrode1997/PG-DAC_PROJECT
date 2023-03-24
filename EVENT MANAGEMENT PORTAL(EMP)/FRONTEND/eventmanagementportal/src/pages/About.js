
import React from 'react';
import { Container, Row, Col, Image } from 'react-bootstrap';

const About = () => {
  return (
    <Container className="my-5">
      <Row>
        <Col md={6}>
          <Image src="https://tse1.mm.bing.net/th?id=OIP.Dyb_o3kOnMR8JmMlMkiXXgHaFj&pid=Api" alt="About Us" fluid />
        </Col>
        <Col md={6}>
          <h2 className="mb-4">About Us</h2>
          <p>
            <h4>
            Our event management system was founded in 2023 with the goal of
            simplifying event planning and management for businesses and
            individuals. We understand how stressful it can be to plan and
            execute an event, so we've created a platform that takes care of
            the details for you.
            </h4>
          </p>
          <p>
            <h4>
            Our team is made up of experienced event planners who are
            passionate about helping others create unforgettable events. We
            offer a variety of features, including ticket sales, event
            promotion, and attendee management, all in one easy-to-use platform.
            </h4>
          </p>
          
          <p>
            <h4>
            Whether you're planning a small business conference or a large-scale
            music festival, our event management system has everything you need
            to make your event a success.
            </h4>
          </p>
        </Col>
      </Row>
    </Container>
  );
};

export default About;
