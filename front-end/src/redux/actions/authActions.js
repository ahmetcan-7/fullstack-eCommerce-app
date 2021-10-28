import { login, signup } from "../../api/apiCalls";
import * as ACTION from "../types/authTypes";

export const logoutSuccess = () => async dispatch => {
	dispatch({
		type: ACTION.LOGOUT_SUCCESS
	});
};

export const loginSuccess = authState => {
	return {
		type: ACTION.LOGIN_SUCCESS,
		payload: authState
	};
};

export const loginHandler = credentials => async dispatch => {
	const response = await login(credentials);
	const authState = {
		...response.data.user,
		password: credentials.password,
		token: response.data.token
	};
	dispatch(loginSuccess(authState));
	return response;
};

export const signupHandler = user => async dispatch => {
	const response = await signup(user);
	await dispatch(loginHandler(user));
	return response;
};
