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
