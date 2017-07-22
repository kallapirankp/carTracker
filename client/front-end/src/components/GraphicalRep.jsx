import React, {Component} from 'react';
var BarChart = require('react-d3-basic').BarChart;

class GraphicalRep extends Component{
	render(){
		if(this.props.data){
			var chartData = this.props.data;

		  	var width = 700,
		    height = 500,
		    title= "Bar Chart",
		   
		    chartSeries = [
		      {
		        field: 'value',
		        name: 'value',
		        color: '#ff7f0e'
		      }
		    ],
		
		    x = function(d) {
		      var date = new Date(d.timestamp);
		      date = date.getMinutes(); 
		      return (date);
		    },
		    xScale = 'ordinal',
		    xLabel = 'Time',
		    yLabel = 'Value';

		    return(
			    <BarChart
			      title={title}
			      data={chartData}
			      width={width}
			      height={height}
			      chartSeries={chartSeries}
			      x={x}
			      xScale={xScale}
			      xLabel={xLabel}
			      yLabel={yLabel}
			    />
			);
		}
			
	}  
}
export default GraphicalRep;