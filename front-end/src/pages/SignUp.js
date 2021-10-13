import React, { useState } from "react"
import "../styles/signup.scss"
import { signup } from "../api/apiCalls"

function SignUp() {
  const [form, setForm] = useState({
    userName: null,
    displayName: null,
    password: null,
    passwordRepeat: null,
  })

  const [pendingApiCall, setPendingApiCall] = useState(false)

  const [disabled, setDisabled] = useState(true)

  const handleInput = (e) => {
    const { name, value } = e.target

    setForm({ ...form, [name]: value })
  }

  const handleDisabled = () => {
    setDisabled(!disabled)
  }

  const handleSubmit = async (e) => {
    e.preventDefault()

    const { userName, displayName, password } = form

    const requestBody = {
      userName,
      displayName,
      password,
    }

    setPendingApiCall(true)
    try {
      const response = await signup(requestBody)
    } catch (err) {}

    setPendingApiCall(false)
  }
  return (
    <div className=" mt-3 signup">
      <h1 className="text-primary">Sign Up</h1>
      <form className="row g-3">
        <div className="col-12">
          <label htmlFor="userName" className="form-label">
            Username
          </label>
          <input
            name="userName"
            className="form-control"
            id="userName"
            onChange={handleInput}
          />
        </div>
        <div className="col-12">
          <label htmlFor="displayName" className="form-label">
            Display Name
          </label>
          <input
            name="displayName"
            className="form-control"
            id="displayName"
            onChange={handleInput}
          />
        </div>
        <div className="col-12">
          <label htmlFor="password" className="form-label">
            Password
          </label>
          <input
            name="password"
            type="password"
            className="form-control"
            id="password"
            onChange={handleInput}
          />
        </div>
        <div className="col-12">
          <label htmlFor="passwordRepeat" className="form-label">
            Password Repeat
          </label>
          <input
            name="passwordRepeat"
            type="password"
            className="form-control"
            id="passwordRepeat"
            onChange={handleInput}
          />
        </div>
        <div className="col-12">
          <div className="form-check">
            <input
              className="form-check-input"
              type="checkbox"
              id="gridCheck"
              onClick={handleDisabled}
            />
            <label className="form-check-label" htmlFor="gridCheck">
              Check me out
            </label>
          </div>
        </div>
        <div className="col-12">
          <button
            type="submit"
            className="btn btn-secondary"
            disabled={disabled || pendingApiCall}
            onClick={handleSubmit}
          >
            {pendingApiCall && (
              <span class="spinner-border spinner-border-sm"></span>
            )}
            Sign Up
          </button>
        </div>
      </form>
    </div>
  )
}

export default SignUp
