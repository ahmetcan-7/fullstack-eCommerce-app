import React, { useState, useEffect } from "react";
import Input from "../components/Input";
import { useTranslation } from "react-i18next";
import ButtonWithProgress from "../components/ButtonWithProgress";
import { useDispatch } from "react-redux";
import { loginHandler } from "../redux//actions/authActions";

function Login({ history }) {
	const [error, setError] = useState();
	const [form, setForm] = useState({
		username: null,
		password: null
	});

	const [pendingApiCall, setPendingApiCall] = useState(false);

	const dispatch = useDispatch();

	useEffect(() => {
		setError(undefined);
	}, [form]);

	const handleChange = e => {
		const { name, value } = e.target;

		setForm({ ...form, [name]: value });
	};

	const handleSubmit = async e => {
		e.preventDefault();

		const creds = { ...form };

		setError(undefined);

		setPendingApiCall(true);
		try {
			await dispatch(loginHandler(creds));
			history.push("/");
		} catch (err) {
			setError(err.response.data.message);
		}

		setPendingApiCall(false);
	};

	const { t } = useTranslation();

	const buttonEnabled = form.username && form.password;

	return (
		<div className=" mt-3 signup">
			<h1 className="text-primary">{t("Login")}</h1>
			<form className="row g-3">
				<Input
					id={"username"}
					label={t("Username")}
					onChange={handleChange}
					name={"username"}
				/>

				<Input
					id={"password"}
					label={t("Password")}
					onChange={handleChange}
					name={"password"}
					type={"password"}
				/>
				{error && <div className="alert alert-danger">{error}</div>}
				<div className="col-12">
					<ButtonWithProgress
						onClick={handleSubmit}
						disabled={!buttonEnabled}
						pendingApiCall={pendingApiCall}
						text={"Login"}
					/>
				</div>
			</form>
		</div>
	);
}

export default Login;
