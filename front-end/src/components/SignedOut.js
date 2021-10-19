import React from "react";
import { Link } from "react-router-dom";
import Flag from "./Flag";
import { useTranslation } from "react-i18next";

function SignedOut({ language, onClick }) {
	const { t } = useTranslation();
	return (
		<div className="navbar-right">
			<Link to="/signup" className="navbar-right-signup">
				{t("Sign Up")}
			</Link>
			<div className="navbar-right-last">
				<Link to="/login" className="navbar-right-last-login">
					{t("Login")}
				</Link>
				<Flag language={language} onClick={onClick} />
			</div>
		</div>
	);
}

export default SignedOut;
