import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { changeCurrentButton, changePageNumber } from "../redux/actions/productActions";

function PageItem({ page }) {
	const { currentButton } = useSelector(state => state.product);
	const dispatch = useDispatch();

	const handleClick = () => {
		dispatch(changePageNumber(page));
		dispatch(changeCurrentButton(page));
	};

	return (
		<>
			<li className={currentButton === page ? "page-item active" : "page-item"}>
				<span
					className="page-link"
					onClick={handleClick}
					style={{ cursor: "pointer" }}
				>
					{page}
				</span>
			</li>
		</>
	);
}

export default PageItem;
