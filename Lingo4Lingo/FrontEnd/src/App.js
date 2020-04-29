import React from "react";
import "./App.css";
import displayHomePage from './home';
import displayAboutPage from './about';
import displayContactPage from './contact';
import displayRegisterForm from './register';
import {Route} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Route exact path="/" component={displayHomePage} />
      <Route exact path="/about" component={displayAboutPage} />
      <Route exact path="/contact" component={displayContactPage} />
      <Route exact path="/register" component={displayRegisterForm} />
    </div>
  );
}

export default App;
