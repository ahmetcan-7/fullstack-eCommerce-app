import React, { useState } from "react"
import "../styles/signup.scss"
import { signup } from "../api/apiCalls"
import Input from "../components/Input"
import { useTranslation } from "react-i18next"

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

    changePasswordRepeatValue(name, value)

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

  const { t } = useTranslation()
  const { userName, displayName, password } = errors

  const changePasswordRepeatValue = (name, value) => {
    if (name === "passwordRepeat") {
      if (form.password !== value) {
        setPasswordRepeat(t("Password mismatch"))
      } else {
        setPasswordRepeat(undefined)
      }
    } else if (name === "password" && form.passwordRepeat != undefined) {
      if (form.passwordRepeat !== value) {
        setPasswordRepeat(t("Password mismatch"))
      } else {
        setPasswordRepeat(undefined)
      }
    }
  }

  return (
    <div className=" mt-3 signup">
      <h1 className="text-primary">{t("Sign Up")}</h1>
      <form className="row g-3">
        <Input
          id={"userName"}
          label={t("Username")}
          onChange={handleChange}
          name={"userName"}
          error={userName}
        />
        <Input
          id={"displayName"}
          label={t("Display Name")}
          onChange={handleChange}
          name={"displayName"}
          error={displayName}
        />
        <Input
          id={"password"}
          label={t("Password")}
          onChange={handleChange}
          name={"password"}
          error={password}
          type={"password"}
        />
        <Input
          id={"passwordRepeat"}
          label={t("Password Repeat")}
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
              {t("I accept all the terms and conditions")}
            </label>
          </div>
        </div>
        <div className="col-12">
          <button
            type="submit"
            className="btn btn-secondary"
            disabled={
              disabled ||
              pendingApiCall ||
              passwordRepeat === "password dismatch"
            }
            onClick={handleSubmit}
          >
            {pendingApiCall && (
              <span className="spinner-border spinner-border-sm"></span>
            )}
            {t("Sign Up")}
          </button>
        </div>
      </form>
    </div>
  )
}

export default SignUp
