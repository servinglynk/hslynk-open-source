// import { createStore, combineReducers } from 'redux';
// import reducers from '../reducers';

// export default function configureStore() {
//   return createStore(
//     combineReducers({
//       ...reducers
//     }),
//     {}
//   );
// }


// import { createStore, applyMiddleware, compose } from "redux";
// import createDebounce from "redux-debounced";
// import thunk from "redux-thunk";
// import reducers from '../reducers';
// // import logger from 'redux-logger'

// const middlewares = [thunk, createDebounce()];

// const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
// const configureStore = createStore(
//    reducers,
//    {},
//    composeEnhancers(applyMiddleware(...middlewares))
// );

// export default  configureStore 	;



import { createStore, applyMiddleware, compose } from 'redux';
import thunkMiddleware from 'redux-thunk'
import reducers from '../reducers';

// const configureStore = createStore(
//     reducers,
//     compose(
//       applyMiddleware(thunkMiddleware),
//       window.devToolsExtension
//         ? window.devToolsExtension()
//         : function (f) {
//             return f;
//           }
//     )
//   );

// export default configureStore;




export default function configureStore() {
  return createStore(
     reducers,
    compose(
      applyMiddleware(thunkMiddleware),
      window.devToolsExtension
        ? window.devToolsExtension()
        : function (f) {
            return f;
          }
    )
  );
}