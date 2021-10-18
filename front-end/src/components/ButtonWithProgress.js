import React from "react";
import { useTranslation } from "react-i18next";

function ButtonWithProgress({
	disabled,
	pendingApiCall,
	passwordRepeat,
	onClick,
	text
}) {
	const { t } = useTranslation();
	return (
		<>
			<button
				type="submit"
				className="btn btn-secondary"
				disabled={
					disabled || pendingApiCall || passwordRepeat === "password dismatch"
				}
				onClick={onClick}
			>
				{pendingApiCall && (
					<span className="spinner-border spinner-border-sm"></span>
				)}
				{t(text)}
			</button>
		</>
	);
}

export default ButtonWithProgress;
