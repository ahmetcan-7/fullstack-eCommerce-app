import React from "react"
import "../styles/signup.scss"

function SignUp() {
  return (
    <div className=" mt-3 signup">
      <h1 className="text-primary">Sign Up</h1>
      <form className="row g-3">
        <div className="col-12">
          <label htmlFor="userName" className="form-label">
            Username
          </label>
          <input type="email" className="form-control" id="userName" />
        </div>
        <div className="col-12">
          <label htmlFor="displayName" className="form-label">
            Display Name
          </label>
          <input type="email" className="form-control" id="displayName" />
        </div>
        <div className="col-12">
          <label htmlFor="password" className="form-label">
            Password
          </label>
          <input type="email" className="form-control" id="password" />
        </div>
        <div className="col-12">
          <label htmlFor="passwordRepeat" className="form-label">
            Password Repeat
          </label>
          <input type="password" className="form-control" id="passwordRepeat" />
        </div>
        <div className="col-12">
          <div className="form-check">
            <input
              className="form-check-input"
              type="checkbox"
              id="gridCheck"
            />
            <label className="form-check-label" htmlFor="gridCheck">
              Check me out
            </label>
          </div>
        </div>
        <div className="col-12">
          <button type="submit" className="btn btn-secondary">
            Sign in
          </button>
        </div>
      </form>
    </div>
  )
}

export default SignUp
