import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { changeCurrentButton, changePageNumber } from "../redux/actions/productActions";
import PageItem from "./PageItem";

const Pagination = ({ pendingApiCall }) => {
	let { currentButton, totalPages } = useSelector(state => state.product);
	const dispatch = useDispatch();

	let numberOfPageItems = [];
	for (let i = 1; i <= totalPages; i++) {
		numberOfPageItems.push(i);
	}

	const handleSelectedPage = selectedButtonNumber => {
		dispatch(changeCurrentButton(selectedButtonNumber));
		dispatch(changePageNumber(selectedButtonNumber));
	};

	const handleClickNext = () => {
		if (currentButton !== totalPages) {
			currentButton = currentButton + 1;
			return handleSelectedPage(currentButton);
		}
	};

	const handleClickPrev = () => {
		if (currentButton !== 1) {
			currentButton = currentButton - 1;
			return handleSelectedPage(currentButton);
		}
	};

	return (
		<>
			<nav aria-label="Page navigation example" style={{ marginTop: "1.5rem" }}>
				<div className="pagination">
					<button
						className="page-item"
						style={{ border: "none", padding: "0px", margin: "0px" }}
						onClick={handleClickPrev}
						disabled={(currentButton === 1) || pendingApiCall}
					>
						<span
							className="page-link"
							aria-label="Previous"
							aria-hidden="true"
							style={{ cursor: "pointer" }}
						>
							&laquo;
						</span>
					</button>
					{numberOfPageItems.map((page, index) => <PageItem page={page} key={index} pendingApiCall={pendingApiCall} />)}
					<button
						className="page-item"
						style={{ border: "none", padding: "0px", margin: "0px" }}
						onClick={handleClickNext}
						disabled={(currentButton === totalPages) || pendingApiCall}
					>
						<span className="page-link"
							aria-label="Next"
							aria-hidden="true"
							style={{ cursor: "pointer" }}
						>
							&raquo;
						</span>
					</button>
				</div>
			</nav>
		</>
	);
};

export default Pagination;
