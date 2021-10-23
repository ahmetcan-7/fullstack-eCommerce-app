import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { changeCurrentButton, changePageNumber } from "../redux/actions/productActions";

function PageItem({ page, pendingApiCall }) {
	const { currentButton } = useSelector(state => state.product);
	const dispatch = useDispatch();

	const handleClick = () => {
		dispatch(changePageNumber(page));
		dispatch(changeCurrentButton(page));
	};

	return (
		<>
			<button
				className={currentButton === page ? "page-item active" : "page-item"}
				style={{ border: "none", padding: "0px", margin: "0px" }}
				disabled={(currentButton === page) || pendingApiCall}
				onClick={handleClick}>
				<span
					className="page-link"
					style={{ cursor: "pointer" }}
				>
					{page}
				</span>
			</button>
		</>
	);
}

export default PageItem;
