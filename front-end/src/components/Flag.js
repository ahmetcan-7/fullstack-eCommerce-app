import React from "react";

function Flag({ language, onClick }) {
	return (
		<>
			<img
				src={`https://www.countryflags.io/${language}/flat/24.png`}
				onClick={onClick}
				alt="flag"
				className="flag"
			></img>
		</>
	);
}

export default Flag;
