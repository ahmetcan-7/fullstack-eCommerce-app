import React from "react"
import { Route } from "react-router"
import SignUp from "../pages/SignUp"

function Dashboard() {
  return (
    <div className="container">
      <Route path="/signup" component={SignUp} />
    </div>
  )
}

export default Dashboard
