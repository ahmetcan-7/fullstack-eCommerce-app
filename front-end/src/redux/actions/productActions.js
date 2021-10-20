import * as ACTION from "../types/productTypes";
import { getProducts } from "../../api/apiCalls";

export const fetchProducts = () => async dispatch => {
	const response = await getProducts();

	dispatch({
		type: ACTION.FETCH_PRODUCTS,
		payload: response.data
	});
};
