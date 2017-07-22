import React, {Component} from 'react';
import {Grid, Row, Col} from 'react-bootstrap';
import axios from 'axios';
import HighAlerts from './HighAlerts';
import Statistics from './Statistics';
import HistoricalAlerts from './HistoricalAlerts';
import '../css/Alerts.css';


class Alerts extends Component{
	constructor(){
		super();
		this.state = {
			highAlertList : [],
		};
	}

	componentWillMount(){
		var self = this;
		const highAlertsUrl = "http://www.localhost:8080/vehicles/getHighAlerts";
		axios.get(highAlertsUrl)
		.then((response) => {
			if(response.data){
				self.setState({
					highAlertList : response.data
				});
			}	
		})
		.catch((error) => {
			console.log(error);
		});
	}

	render(){
		return(	<div className="alerts" id = "alert-section">
					<Grid>
						<Row className="show-grid alert-heading">
						<h1> Alerts </h1>
						</Row>
						<Row className="show-grid alert-contents">
							<Col>
								<div className="column">
									<h2> High Alerts </h2>
									<h3> The high alerts for all vehicles within two hours is listed here </h3>
									<HighAlerts alertList={this.state.highAlertList} />
								</div>
							</Col>
							<Col >
								<div className="column">
									<h2> Statistics </h2>
									<h5> The statistics such as EngineRpm, Speed for each vehicle is represented here </h5>
									<Statistics vehicleList={this.props.vehicleList} />
								</div>
							</Col>
							<Col>
								<div className="column">
									<h2> Historical Alerts </h2>
									<h5> Select a Vehicle to view all of its Alerts </h5>
									<HistoricalAlerts vehicleList={this.props.vehicleList} /> 
								</div>
							</Col>
						</Row>
					</Grid>
				</div>
			);
	}
}
export default Alerts;