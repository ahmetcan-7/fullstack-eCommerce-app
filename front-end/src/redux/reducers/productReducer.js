import * as ACTION from "../types/productTypes";

const initialState = {
	products: [],
	totalPages: 0,
	pageNumber: 1,
	currentButton: 1
};

export default function productReducer(state = { ...initialState }, { type, payload }) {
	switch (type) {
		case ACTION.FETCH_PRODUCTS:
			return {
				...state,
				products: payload.content,
				totalPages: payload.totalPages,
				pageNumber: payload.pageable.pageNumber + 1,
				pageSize: payload.pageable.pageSize
			};

		case ACTION.CHANGE_PAGE_NUMBER:
			return {
				...state,
				pageNumber: payload
			};

		case ACTION.CHANGE_CURRENT_BUTTON:
			return {
				...state,
				currentButton: payload
			};
		default:
			return state;
	}
}
