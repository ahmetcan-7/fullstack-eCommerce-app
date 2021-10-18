import React from "react";

function Input({ name, id, onChange, error, label, type }) {
	let className = "form-control";

	if (error !== undefined) {
		className += " is-invalid";
	}

	return (
		<div className="col-12">
			<label htmlFor={id} className="form-label">
				{label}
			</label>
			<input
				name={name}
				className={className}
				id={id}
				onChange={onChange}
				type={type}
			/>
			<div className="invalid-feedback">{error}</div>
		</div>
	);
}

export default Input;
