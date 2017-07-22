import React, { Component } from 'react';
import axios from 'axios';
import '../css/App.css';
import Header from './Header';
import Home from './Home';
import Vehicles from './Vehicles';
import Alerts from './Alerts';
import Location from './Location';


class AppComponent extends Component {
  constructor(){
    super();
    this.state = {
      vehicleList : []
    }
  }
  componentWillMount(){
    var self = this;
    const vehicleUrl = "http://www.localhost:8080/vehicles";
    axios.get(vehicleUrl)
    .then((response) => {
      if(response.data){
        self.setState({
          vehicleList : response.data
        });
      }
    })
    .catch((error) => {
      console.log(error);
    });
  }

  render() {
    return (
      <div className="App">
        <Header />
        <Home />
        <Vehicles vehicleList={this.state.vehicleList} />
        <Alerts vehicleList={this.state.vehicleList} />
        <Location vehicleList={this.state.vehicleList} />
      </div>
    );
  }
}

export default AppComponent;
