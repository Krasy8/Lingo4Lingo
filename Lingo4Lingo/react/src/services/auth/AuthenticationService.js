import axios from "axios";

const API_URL = "http://localhost:8080";

export const USER_NAME_SESSION_ATTRIBUTE_NAME = "authenticatedUser";

class AuthenticationService {
  executeBasicAuthenticationService(login, password) {
    return axios.get(`${API_URL}/reactAuth`, {
      headers: { Authorization: this.createBasicAuthToken(login, password) },
    });
  }

  createBasicAuthToken(login, password) {
    return "Basic " + window.btoa(login + ":" + password);
  }

  registerSuccessfulLogin(login, password) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, login);
    this.setupAxiosInterceptors(this.createBasicAuthToken(login, password));
  }

  registrationUnsuccessfulLogin(login, password) {
    console.log(
      "Unsuccessful Authentication! Provided login: " +
        login +
        " and/or password: " +
        password +
        " were incorrect."
    );
  }

  setupAxiosInterceptors(token) {
    axios.interceptors.request.use((config) => {
      if (this.isUserLoggedIn()) {
        config.headers.authorization = token;
      }
      return config;
    });
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    return user !== null;
  }

  logout() {
    sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
  }

  getLoggedUserName() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null) return "";
    return user;
  }
}

export default new AuthenticationService();
