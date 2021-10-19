import React from "react";
import { Link } from "react-router-dom";
import Flag from "./Flag";
import { useTranslation } from "react-i18next";
import { useDispatch } from "react-redux";
import { logoutSuccess } from "../redux/actions/authActions";

function SignedIn({ language, onClick, displayName, username }) {
	const { t } = useTranslation();
	const dispatch = useDispatch();

	const handleLogOut = () => {
		dispatch(logoutSuccess());
	};

	return (
		<div className="navbar-right">
			<Link to={`/user/${username}`} className="navbar-right-signup">
				{displayName}
			</Link>
			<div className="navbar-right-last">
				<span className="navbar-right-last-login" onClick={handleLogOut}>
					{t("Logout")}
				</span>
				<Flag language={language} onClick={onClick} />
			</div>
		</div>
	);
}

export default SignedIn;
