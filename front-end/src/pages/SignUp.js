import React, { useState } from "react"
import "../styles/signup.scss"
import { signup } from "../api/apiCalls"
import Input from "../components/Input"

function SignUp() {
  const [form, setForm] = useState({
    userName: null,
    displayName: null,
    password: null,
    passwordRepeat: null,
  })

  const [pendingApiCall, setPendingApiCall] = useState(false)

  const [disabled, setDisabled] = useState(true)

  const [errors, setErrors] = useState({})

  const [passwordRepeat, setPasswordRepeat] = useState(undefined)

  const handleChange = (e) => {
    const { name, value } = e.target

    if (name === "passwordRepeat") {
      if (form.password !== value) {
        setPasswordRepeat("password dismatch")
      } else {
        setPasswordRepeat(undefined)
      }
    }

    setForm({ ...form, [name]: value })
    setErrors({ ...errors, [name]: undefined })
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
    } catch (err) {
      setErrors(err.response.data)
    }

    setPendingApiCall(false)
  }

  const { userName, displayName, password } = errors

  return (
    <div className=" mt-3 signup">
      <h1 className="text-primary">Sign Up</h1>
      <form className="row g-3">
        <Input
          id={"userName"}
          label={"User Name"}
          onChange={handleChange}
          name={"userName"}
          error={userName}
        />
        <Input
          id={"displayName"}
          label={"Display Name"}
          onChange={handleChange}
          name={"displayName"}
          error={displayName}
        />
        <Input
          id={"password"}
          label={"Password"}
          onChange={handleChange}
          name={"password"}
          error={password}
          type={"password"}
        />
        <Input
          id={"passwordRepeat"}
          label={"Password Repeat"}
          onChange={handleChange}
          name={"passwordRepeat"}
          error={passwordRepeat}
          type={"password"}
        />
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
              <span className="spinner-border spinner-border-sm"></span>
            )}
            Sign Up
          </button>
        </div>
      </form>
    </div>
  )
}

export default SignUp
