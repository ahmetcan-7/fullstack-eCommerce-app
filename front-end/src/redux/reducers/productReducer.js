import * as ACTION from "../types/productTypes";

const initialState = {
	products: []
};

export default function productReducer(
	state = { ...initialState },
	{ type, payload }
) {
	switch (type) {
		case ACTION.FETCH_PRODUCTS:
			return {
				...state,
				products: payload
			};

		default:
			return state;
	}
}
