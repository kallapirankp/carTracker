import React, {Component} from 'react';
import '../css/Header.css';
import {Navbar, Nav, NavItem} from 'react-bootstrap';
import Scroll from 'react-scroll';

const Link = Scroll.Link;

class Header extends Component{

	state = {
		expanded : {}
	}

	setNavExpanded = (expanded) => {
		this.setState({ navExpanded: expanded });
	}

	closeNav = () => {
	  	this.setState({ navExpanded: false });
	}


	render(){
		return (<div className="header">
				<Navbar fixedTop 
					onToggle={this.setNavExpanded}
					expanded={this.state.navExpanded}>
					<Navbar.Header>
						<Navbar.Brand>
							<a href="#home"> Car Tracker </a>
						</Navbar.Brand>
						<Navbar.Toggle />
					</Navbar.Header>
					<Navbar.Collapse>
						<Nav pullRight>
							<NavItem href="#home-section"> <Link onClick={this.closeNav} activeClass="" to="home-section" spy={false} smooth={true} duration={500}> Home </Link></NavItem>
							<NavItem href="#vehicle-section"> <Link onClick={this.closeNav} activeClass="" to="vehicle-section" spy={false} smooth={true} duration={500}> Vehicles </Link> </NavItem>
							<NavItem href="#alert-section"> <Link onClick={this.closeNav} activeClass="" to="alert-section" spy={false} smooth={true} duration={500}> Alerts </Link> </NavItem>
							<NavItem href="#location-section"> <Link onClick={this.closeNav} activeClass="" to="location-section" spy={false} smooth={true} duration={500}> Location </Link> </NavItem>
						</Nav>
					</Navbar.Collapse>
				</Navbar>
			</div>);
	}
	
}

export default Header;
