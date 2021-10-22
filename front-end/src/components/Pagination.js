import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { changeCurrentButton, changePageNumber } from "../redux/actions/productActions";
import PageItem from "./PageItem";

const Pagination = () => {
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
				<ul className="pagination">
					<li
						className={currentButton === 1 ? "page-item disabled" : "page-item"}
						onClick={handleClickPrev}
					>
						<span
							className="page-link"
							aria-label="Previous"
							aria-hidden="true"
							style={{ cursor: "pointer" }}
						>
							&laquo;
						</span>
					</li>
					{numberOfPageItems.map((page, index) => <PageItem page={page} key={index} />)}
					<li
						className={currentButton === totalPages ? "page-item disabled" : "page-item"}
						onClick={handleClickNext}
					>
						<span className="page-link"
							aria-label="Next"
							aria-hidden="true"
							style={{ cursor: "pointer" }}
						>
							&raquo;
						</span>
					</li>
				</ul>
			</nav>
		</>
	);
};

export default Pagination;
