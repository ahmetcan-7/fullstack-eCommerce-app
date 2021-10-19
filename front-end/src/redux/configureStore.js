import { applyMiddleware, createStore, compose } from "redux";
import rootReducer from "./rootReducer";
import thunk from "redux-thunk";
import SecureLS from "secure-ls";

const secureLs = new SecureLS();

const getStateFromStorage = () => {
	const hoaxAuth = secureLs.get("auth");

	let stateInLocalStorage = {
		isLoggedIn: false,
		username: undefined,
		displayName: undefined,
		password: undefined
	};

	if (hoaxAuth) {
		return hoaxAuth;
	}
	return stateInLocalStorage;
};

const updateStateInStorage = newState => {
	secureLs.set("auth", newState);
};

export function configureStore() {
	const initialState = getStateFromStorage();
	const composeEnhancers =
		window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
	const store = createStore(
		rootReducer,
		initialState,
		composeEnhancers(applyMiddleware(thunk))
	);

	store.subscribe(() => {
		updateStateInStorage(store.getState());
	});

	return store;
}
