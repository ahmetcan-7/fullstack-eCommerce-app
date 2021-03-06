import React from "react";
import { Route } from "react-router";
import Login from "../pages/Login";
import ProductList from "../pages/ProductList";
import SignUp from "../pages/SignUp";

function Dashboard() {
	return (
		<div className="container">
			<Route exact path="/" component={ProductList} />
			<Route path="/signup" component={SignUp} />
			<Route path="/login" component={Login} />
		</div>
	);
}

export default Dashboard;
