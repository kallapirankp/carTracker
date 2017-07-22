import React, {Component} from 'react';
import {Table, Row, Col, Grid, DropdownButton, MenuItem} from 'react-bootstrap';
import axios from 'axios';
import Timestamp from 'react-timestamp';
import '../css/HistoricalAlerts.css';


class HistoricalAlerts extends Component{
	constructor(props){
		super(props);
		this.state = {
			vehicleAlerts : [],
			vehicle : {}
		}
	}

	componentWillReceiveProps(nextProps){
		this.setState({
			vehicle : nextProps.vehicleList[0]
		}, () => {this.handleVehicleChange(this.state.vehicle)});
		
	}

	handleVehicleChange(event){
		var self = this;
		const getHistoricalAlertsUrl = "http://www.localhost:8080/readings/getHistoricalAlerts/"+event.vin;
		axios.get(getHistoricalAlertsUrl)
		.then((response) => {
			self.setState({
				vehicleAlerts : response.data,
				vehicle : event
			});
		})
		.catch((error) =>{
			console.log(error);
		});
	}

	render(){
		var nameOfCar = this.state.vehicle.make + this.state.vehicle.model ;

		return ( <div className="historicalAlerts">
					<Grid>
						<Row className="show-grid">
							<Col>
								<h4> Select a Car </h4>
								<DropdownButton title={nameOfCar} id={nameOfCar} onSelect={(event) => {this.handleVehicleChange(event)}}>
									{this.props.vehicleList.map((vehicle) => {
										return (<MenuItem key={vehicle.vin} eventKey={vehicle}>{vehicle.make}{vehicle.model}</MenuItem>);
										}
									)}
								</DropdownButton>
							</Col>
						</Row>

						<Row className="show-grid show-table">
							<Col>
								<Table striped bordered condensed hover responsive>
								    <thead>
								      <tr>
								        <th>#</th>
								        <th>Time</th>
								        <th>High Alert</th>
								        <th>Medium Alert</th>
								        <th>Low Alert 1</th>
								        <th>Low Alert 2</th>
								      </tr>
								    </thead>
								    <tbody>
								    {this.state.vehicleAlerts.map((singleAlert, i=1) => {
								    	return (<tr key={singleAlert.alert.id}>
								    				<td>{i++}</td>
											        <td><Timestamp time={singleAlert.timestamp} format='full' includeDay /></td>
											        <td>{singleAlert.alert.highAlertType}</td>
											        <td>{singleAlert.alert.mediumAlertType}</td>
											        <td>{singleAlert.alert.lowAlertType1}</td>
											        <td>{singleAlert.alert.lowAlertType2}</td>
											      </tr>
											    );
								    	})
									}
								    </tbody>
							  	</Table>
							</Col>
						</Row>
					</Grid>
				</div>
			);
	}

}

export default HistoricalAlerts;