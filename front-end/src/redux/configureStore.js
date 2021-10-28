import { applyMiddleware, createStore, compose } from "redux";
import rootReducer from "./rootReducer";
import thunk from "redux-thunk";
import SecureLS from "secure-ls";
import { setAuthorizationHeader } from "../api/apiCalls";

const secureLs = new SecureLS();

const getStateFromStorage = () => {
	const auth = secureLs.get("auth");

	let stateInLocalStorage = {
		auth: {
			isLoggedIn: false,
			username: undefined,
			displayName: undefined,
			password: undefined,
		}
	};
	if (auth) {
		return auth;
	}
	return stateInLocalStorage;
};

const updateStateInStorage = newState => {
	const newStateOfAuth = { auth: newState }
	secureLs.set("auth", newStateOfAuth);
};

export function configureStore() {
	const initialState = getStateFromStorage();
	setAuthorizationHeader(initialState.auth);
	const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
	const store = createStore(
		rootReducer,
		initialState,
		composeEnhancers(applyMiddleware(thunk))
	);

	store.subscribe(() => {
		updateStateInStorage(store.getState().auth);
		setAuthorizationHeader(store.getState().auth);
	});



	return store;
}
