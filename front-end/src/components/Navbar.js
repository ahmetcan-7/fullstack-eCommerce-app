import React from "react"
import "../styles/navbar.scss"
import { Link } from "react-router-dom"

function Navbar() {
  return (
    <div>
      <nav className="menu navbar navbar-expand-lg  ">
        <div className="container-md ">
          <a href="#!" className="navbar-brand ">
            Navbar
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a href="#!" className="nav-link active" aria-current="page">
                  Home
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link active" href="#!">
                  Massages
                </a>
              </li>
            </ul>
            <Link to="/signup">Sign Up</Link>
          </div>
        </div>
      </nav>
    </div>
  )
}

export default Navbar
