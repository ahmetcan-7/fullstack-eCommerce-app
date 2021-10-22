import axios from "axios";

export const signup = requestBody => {
	return axios.post("/v1/user", requestBody);
};

export const changeValidationLanguage = language => {
	axios.defaults.headers["accept-language"] = language;
};

export const login = creds => {
	return axios.post("/v1/user/auth", {}, { auth: creds });
};

export const getProducts = (pageNo, pageSize, sortBy) => {
	return axios.get(
		`/v1/product/getAllByPage?pageNo=${pageNo}&pageSize=${pageSize}&sortBy=${sortBy}`
	);
};
