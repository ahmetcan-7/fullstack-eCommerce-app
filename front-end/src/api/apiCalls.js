import axios from "axios";

export const signup = requestBody => {
	return axios.post("/v1/user", requestBody);
};

export const changeValidationLanguage = language => {
	axios.defaults.headers["accept-language"] = language;
};

export const login = creds => {
	return axios.post("/v1/user/auth", creds);
};

export const getProducts = (pageNo, pageSize, sortBy) => {
	return axios.get(
		`/v1/product/getAllByPage?pageNo=${pageNo}&pageSize=${pageSize}&sortBy=${sortBy}`
	);
};

export const setAuthorizationHeader = ({ isLoggedIn, token }) => {
	if (isLoggedIn) {
		const authorizationHeaderValue = `Bearer ${token}`;
		axios.defaults.headers['Authorization'] = authorizationHeaderValue;
	} else {
		delete axios.defaults.headers['Authorization'];
	}
};
