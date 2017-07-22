import React, {Component} from 'react';

import GoogleMapReact from 'google-map-react';
import '../css/SimpleMapPage.css';

const MyGreatPlace = ({ text }) => <div>{text}</div>;

class LocationMap extends Component {

  static defaultProps = {
    center: {lat: 37.3188854,lng: -121.9778652},
    zoom: 9,
  };

  render(){
    return (
      <div className="simpleMap">
      <GoogleMapReact
        defaultCenter={this.props.center}
        defaultZoom={this.props.zoom}
      >
      {this.props.locationData.map((location) => {
          return (<MyGreatPlace key={location.time} lat={location.latitude} lng={location.longitude} text={'o'} />
            );
          })
      }
        
      </GoogleMapReact>
      </div>
    );
  }
}
export default LocationMap;

