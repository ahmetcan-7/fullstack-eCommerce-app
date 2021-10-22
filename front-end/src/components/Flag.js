import React from "react";

function Flag({ language, onClick }) {
	return (
		<>
			<img
				src={`/assets/${language}-flag.png`}
				onClick={onClick}
				alt="flag"
				className="flag"
				width="32px"
				height="20px"
			></img>
		</>
	);
}

export default Flag;
