import React from 'react';
import {Carousel} from 'react-bootstrap';
import "../css/Home.css"


function Home(){

	return (<div className="home-page" id="home-section">
				<Carousel bsClass="carousel">
				    <Carousel.Item>
				      <img width={900} height={500} alt="900x500" src="http://via.placeholder.com/900x500"/>
				      <Carousel.Caption>
				        <h1>Welcome To Car Tracker </h1>
				        <h3>In this application, you can find all details about the cars that are monitored.</h3>
				      </Carousel.Caption>
				    </Carousel.Item>
				    <Carousel.Item>
				      <img width={900} height={500} alt="900x500" src="http://via.placeholder.com/900x500"/>
				      <Carousel.Caption>
				        <h1>Never miss an Alert</h1>
				        <h3>The cars are being continously monitored, so that you dont have to worry about them.</h3>
				      </Carousel.Caption>
				    </Carousel.Item>
				    <Carousel.Item>
				      <img width={900} height={500} alt="900x500" src="http://via.placeholder.com/900x500"/>
				      <Carousel.Caption>
				        <h1>Track the Car's geo Location</h1>
				        <h3> The geo Locations of the car are continously being monitored. So no Theft worries.</h3>
				      </Carousel.Caption>
				    </Carousel.Item>
				</Carousel>
			</div>
		);
}

export default Home;