import React, { useState } from "react";
import "../styles/signup.scss";
import Input from "../components/Input";
import { useTranslation } from "react-i18next";
import ButtonWithProgress from "../components/ButtonWithProgress";
import { useDispatch } from "react-redux";
import { signupHandler } from "../redux/actions/authActions";
import { useApiProgress } from '../shared/ApiProgress';

function SignUp({ history }) {
	const [form, setForm] = useState({
		username: null,
		displayName: null,
		password: null,
		passwordRepeat: null
	});


	const [disabled, setDisabled] = useState(true);

	const [errors, setErrors] = useState({});

	const [passwordRepeat, setPasswordRepeat] = useState(undefined);

	const dispatch = useDispatch();

	const controlPasswordDismatchError = (name, value) => {
		if (name === "passwordRepeat") {
			if (form.password !== value) {
				setPasswordRepeat("password dismatch");
			} else {
				setPasswordRepeat(undefined);
			}
		} else if (name === "password" && form.passwordRepeat != undefined) {
			if (form.passwordRepeat !== value) {
				setPasswordRepeat("password dismatch");
			} else {
				setPasswordRepeat(undefined);
			}
		}
	};

	const handleChange = e => {
		const { name, value } = e.target;

		controlPasswordDismatchError(name, value);

		setForm({ ...form, [name]: value });
		setErrors({ ...errors, [name]: undefined });
	};

	const handleDisabled = () => {
		setDisabled(!disabled);
	};

	const handleSubmit = async e => {
		e.preventDefault();

		const { username, displayName, password } = form;

		const requestBody = {
			username,
			displayName,
			password
		};

		try {
			await dispatch(signupHandler(requestBody));
			history.push("/");
		} catch (err) {
			setErrors(err.response.data);
		}

	};

	const { t } = useTranslation();

	const pendingApiCallSignup = useApiProgress('post', '/v1/user');
	const pendingApiCallLogin = useApiProgress('post', '/v1/user/auth');
	const pendingApiCall = pendingApiCallSignup || pendingApiCallLogin;

	const { username, displayName, password } = errors;

	return (
		<div className=" mt-3 signup">
			<h1 className="text-primary">{t("Sign Up")}</h1>
			<form className="row g-3">
				<Input
					id={"username"}
					label={t("Username")}
					onChange={handleChange}
					name={"username"}
					error={username}
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
					<ButtonWithProgress
						disabled={disabled}
						pendingApiCall={pendingApiCall}
						passwordRepeat={passwordRepeat}
						onClick={handleSubmit}
						text={"Sign Up"}
					/>
				</div>
			</form>
		</div>
	);
}

export default SignUp;
