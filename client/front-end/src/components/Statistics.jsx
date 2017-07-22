import React, {Component} from 'react';
import {Grid, Row, Col, Button, DropdownButton, MenuItem} from 'react-bootstrap';
import GraphicalRep from './GraphicalRep';
import axios from 'axios';

class Statistics extends Component {
	constructor(props){
		super(props);

		this.state = {
			vehicle : {},
			content : "fuelVolume",
			time : "15",
			data : []
		}
	}

	componentWillReceiveProps(nextProps){
		
		this.setState({
			vehicle : nextProps.vehicleList[0],
			content : "fuelVolume",
			time : "15"
		}, () => {this.handleSubmitClick();});
		
	}

	handleVehicleChange(event){
			this.setState({
				vehicle : event
			});
	}

	handleContentChange(event){
			this.setState({
				content : event
			});
	}

	handleTimeChange(event){
			this.setState({
				time : event
			});
	}

	handleSubmitClick(){
		var self = this;
		console.log("It enters submit");
		const getstatisticsUrl = "http://www.localhost:8080/readings/getSpecificSignal/"+this.state.vehicle.vin+"/"+this.state.content+"/"+this.state.time;
		axios.get(getstatisticsUrl)
		.then((response) => {
			console.dir(response);
			self.setState({
				data : response.data
			});
		})
		.catch((error) => {
			console.log(error);
		});
	}

	render(){
		var nameOfCar = this.state.vehicle.make + this.state.vehicle.model ;

		return(	<div className="statistics">
					<Grid>
						<Row className="show-grid">
							<Col xs={18} md={3} lg={3}>
								<DropdownButton title={nameOfCar} id={this.state.vehicle} onSelect={(event) => {this.handleVehicleChange(event)}}>
									{this.props.vehicleList.map((vehicle) => {
										return (<MenuItem key={vehicle.vin} eventKey={vehicle}>{vehicle.make}{vehicle.model}</MenuItem>);
										}
									)}
								</DropdownButton>
							</Col>
							<Col xs={18} md={3} lg={3}>
								<DropdownButton title={this.state.content} id={this.state.content} onSelect={this.handleContentChange.bind(this)}>
									<MenuItem eventKey="fuelVolume"> Fuel Volume </MenuItem>
									<MenuItem eventKey="speed"> Speed </MenuItem>
									<MenuItem eventKey="engineRpm"> Engine Rpm </MenuItem>
									<MenuItem eventKey="engineHp"> Engine Hp </MenuItem>
								</DropdownButton>
							</Col>
							<Col xs={18} md={3} lg={3}>
								<DropdownButton title={this.state.time} id={this.state.time} onSelect={this.handleTimeChange.bind(this)}>
									<MenuItem eventKey="15"> 15 minutes </MenuItem>
									<MenuItem eventKey="30"> 30 minutes </MenuItem>
									<MenuItem eventKey="60"> 1 hour </MenuItem>
									<MenuItem eventKey="120"> 2 hours </MenuItem>
								</DropdownButton>
							</Col>
							<Col xs={18} md={3} lg={3}>
								<Button bsSize="small" bsStyle="primary" onClick={this.handleSubmitClick.bind(this)}> Go </Button>
							</Col>
						</Row>

						<Row className="show-grid">
							<Col xs={18} md={12} lg={12}>
								<GraphicalRep data={this.state.data}/>
							</Col>
						</Row>
					</Grid>
				</div>
			);
	}

}

export default Statistics;

