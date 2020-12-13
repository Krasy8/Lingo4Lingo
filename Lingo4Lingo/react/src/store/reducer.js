const initialState = {
  userAuth: false,
};

const reducer = (state = initialState, action) => {
  if (action.type === "USER_AUTHORISATION") {
    return {
      userAuth: true,
    };
  }
  if (action.type === "USER_LOG_OUT") {
    return {
      userAuth: false,
    };
  }
  return state;
};

export default reducer;
