import React, { useEffect, useState } from "react";
import "../styles/navbar.scss";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";
import { changeValidationLanguage } from "../api/apiCalls";
import SignedOut from "./SignedOut";
import { useSelector } from "react-redux";
import SignedIn from "./SignedIn";

function Navbar() {
	const { t, i18n } = useTranslation();
	const [language, setLanguage] = useState("us");

	const { username, isLoggedIn, displayName } = useSelector(
		state => state.auth
	);

	const handleClick = () => {
		if (language === "us") {
			setLanguage("tr");
		} else if (language === "tr") {
			setLanguage("us");
		}
	};

	useEffect(() => {
		i18n.changeLanguage(language);
		changeValidationLanguage(language);
	}, [language]);

	return (
		<div>
			<nav className="menu navbar navbar-expand-lg  ">
				<div className="container-md ">
					<Link to="/" className="navbar-brand ">
						Navbar
					</Link>
					<button
						className="navbar-toggler"
						type="button"
						data-bs-toggle="collapse"
						data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent"
						aria-expanded="false"
						aria-label="Toggle navigation"
					>
						<span className="navbar-toggler-icon hamburger-icon">
							<svg height="24" width="24" viewBox="0 0 24 24">
								<path d="M2.25 18.753h19.5a.75.75 0 0 0 0-1.5H2.25a.75.75 0 0 0 0 1.5zm0-6h19.5a.75.75 0 0 0 0-1.5H2.25a.75.75 0 0 0 0 1.5zm0-6h19.5a.75.75 0 0 0 0-1.5H2.25a.75.75 0 0 0 0 1.5z"></path>
							</svg>
						</span>
					</button>
					<div className="collapse navbar-collapse" id="navbarSupportedContent">
						<ul className="navbar-nav me-auto mb-2 mb-lg-0">
							<li className="nav-item">
								<Link to="/" className="nav-link active" aria-current="page">
									{t("Home")}
								</Link>
							</li>
							<li className="nav-item">
								<a className="nav-link active" href="#!">
									{t("Messages")}
								</a>
							</li>
						</ul>
						{isLoggedIn ? (
							<SignedIn
								displayName={displayName}
								language={language}
								onClick={handleClick}
								username={username}
							/>
						) : (
							<SignedOut language={language} onClick={handleClick} />
						)}
					</div>
				</div>
			</nav>
		</div>
	);
}

export default Navbar;
