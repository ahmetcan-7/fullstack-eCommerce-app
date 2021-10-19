import * as ACTION from "../types/authTypes";

const initialState = {
	isLoggedIn: false,
	username: undefined,
	displayName: undefined,
	password: undefined
};

const authReducer = (state = { ...initialState }, { type, payload }) => {
	switch (type) {
		case ACTION.LOGOUT_SUCCESS:
			return initialState;

		case ACTION.LOGIN_SUCCESS:
			return {
				...payload,
				isLoggedIn: true
			};

		default:
			return state;
	}
};
export default authReducer;
