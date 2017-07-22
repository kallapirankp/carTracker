import React from 'react';
import VehicleBar from './VehicleBar';
import '../css/Vehicle.css';


function Vehicles({vehicleList}){
		return (<div className="vehicle" id = "vehicle-section">
					<h1> Vehicles </h1>
					<h4> You can take a look at all the vehicles below. </h4>
					<h6> Click on a vehicle to see more details </h6>
					<div className="vehicle-list">
					{vehicleList.map((vehicle) => {
						return (<VehicleBar vin={vehicle.vin} key={vehicle.vin} make={vehicle.make} model={vehicle.model} year={vehicle.year}
									redlineRpm={vehicle.redlineRpm} maxFuelVolume={vehicle.maxFuelVolume} lastServiceDate={vehicle.lastServiceDate} />);
					})}
					</div>

				</div>);
}

export default Vehicles;