import React, {Component} from 'react';
import {Collapse, Label, Well} from 'react-bootstrap';
import Timestamp from 'react-timestamp';
import '../css/VehicleBar.css';

class VehicleBar extends Component{
	constructor(props){
		super(props);
		this.state = {};
	}

	render(){
		return( <div className="vehicleBar" onClick={ () => this.setState({open: !this.state.open})}>
					<div className = "vehicleBar-summary">	
						<h4> {this.props.make} {this.props.model}</h4> <h5><Label>{this.props.vin}</Label></h5>
					</div>
					<Collapse in={this.state.open}>
						<div>
							<Well>
								<h4> Vin : {this.props.vin} </h4> <br/>
								<h4> Make : {this.props.make} </h4> <br/>
								<h4> Model : {this.props.model} </h4> <br/>
								<h4> Year : {this.props.year} </h4> <br/>
								<h4> RedLineRpm : {this.props.redlineRpm} </h4> <br/>
								<h4> Maximum FuelVolume : {this.props.maxFuelVolume} </h4> <br/>
								<h4> Last Service Date : <Timestamp time={this.props.lastServiceDate.replace('Z', '+0000')} utc={false} format='full'/> </h4>
							</Well>
						</div>
					</Collapse>
				</div>
			);
	}
}

export default VehicleBar;