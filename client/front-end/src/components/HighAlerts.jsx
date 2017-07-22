import React, {Component} from 'react';
import {Table, Button} from 'react-bootstrap';
import '../css/HighAlerts.css';


class HighAlerts extends Component{
	constructor(props){
		super(props);
		this.state = {
			toggleOrder : true
		}
	}

	handleClick() {
		this.setState({
			toggleOrder : !this.state.toggleOrder
		});
	}


	render(){
		let sortedList = [];
		let buttonDisplay = '';
		if(this.state.toggleOrder){
			sortedList = this.props.alertList.sort((a,b) => parseInt(a.count, 10) - parseInt(b.count, 10));
			buttonDisplay = 'Descending';
		}else{
			sortedList = this.props.alertList.sort((a,b) => parseInt(b.count, 10) - parseInt(a.count, 10));
			buttonDisplay = 'Ascending';
		}

		return(	<div>
					<Table striped bordered condensed hover responsive>
					    <thead>
					      <tr>
					        <th>Vehicle</th>
					        <th>No. of HighAlerts</th>
					      </tr>
					    </thead>
					    <tbody>
					    {sortedList.map((alert) => {
					    	return (<tr key={alert.vehicle.vin}>
								        <td>{alert.vehicle.make} {alert.vehicle.model}</td>
								        <td>{alert.count}</td>
								      </tr>
								    );
					    	})
						}
					    </tbody>
				  	</Table>
				  	<Button bsSize="small" onClick={this.handleClick.bind(this)}> Show in {buttonDisplay} Order </Button>
				</div>
		);
	}
}

export default HighAlerts;