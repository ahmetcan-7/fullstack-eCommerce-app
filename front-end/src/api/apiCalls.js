import axios from "axios"

export const signup = (requestBody) => {
  return axios.post("/v1/user", requestBody)
}
