import React, {Component} from 'react';
import {Grid, Row, Col, DropdownButton, MenuItem} from 'react-bootstrap';
import LocationMap from './LocationMap';
import axios from 'axios';
import '../css/Location.css';


class Location extends Component{
	constructor(props){
		super(props);
		this.state = {
			vehicle : {},
			locationList : []
		}
	}

	componentWillReceiveProps(nextProps){
		this.setState({
			vehicle : nextProps.vehicleList[0]
		}, () => {this.handleVehicleChange(this.state.vehicle)});
	}

	handleVehicleChange(event){
		var self = this;
		const locationUrl = "http://www.localhost:8080/readings/geoLocation/"+event.vin;
		axios.get(locationUrl)
		.then((response) => {
			self.setState({
				vehicle : event,
				locationList : response.data
			});
		})
		.catch((error) => {
			console.log(error);
		})
		
	}

	render(){
		var nameOfCar = this.state.vehicle.make + this.state.vehicle.model;
		return(	<div className="location" id="location-section">
					<Grid>
						<Row className="show-grid">
							<Col xs={18} md={12} lg={12}>
								<h2> Locating the Vehicle </h2>
								<h5> Select a Vehicle to see its location for the past half-an-hour </h5>
								<h4> Select a Car </h4>
							</Col>
						</Row>
						<Row className="show-grid">
							<Col xs={18} md={12} lg={12}>
								<DropdownButton title={nameOfCar} id={nameOfCar} onSelect={(event) => {this.handleVehicleChange(event)}}>
									{this.props.vehicleList.map((vehicle) => {
										return (<MenuItem key={vehicle.vin} eventKey={vehicle}>{vehicle.make}{vehicle.model}</MenuItem>);
										}
									)}
								</DropdownButton>
							</Col>
						</Row>
						<Row className="show-grid location-map">
							<Col xs={18} md={12} lg={12}>
								<LocationMap locationData={this.state.locationList} />
							</Col>
						</Row>
					</Grid>
				</div>
			);
	}
}

export default Location;