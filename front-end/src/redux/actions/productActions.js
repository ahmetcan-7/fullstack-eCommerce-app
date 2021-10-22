import * as ACTION from "../types/productTypes";
import { getProducts } from "../../api/apiCalls";

export const fetchProducts = (pageNo, pageSize, shortBy) => async dispatch => {
	const response = await getProducts(pageNo, pageSize, shortBy);

	dispatch({
		type: ACTION.FETCH_PRODUCTS,
		payload: response.data
	});
};

export const changePageNumber = pageNumber => async dispatch => {
	dispatch({
		type: ACTION.CHANGE_PAGE_NUMBER,
		payload: pageNumber
	});
};

export const changeCurrentButton = currentButton => async dispatch => {
	dispatch({
		type: ACTION.CHANGE_CURRENT_BUTTON,
		payload: currentButton
	});
};
