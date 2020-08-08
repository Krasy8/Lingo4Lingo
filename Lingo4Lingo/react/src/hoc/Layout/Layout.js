import React, { Component } from "react";

import Header from "../../components/Header/Header";
import NavigationBar from "../../containers/NavigationBar/NavigationBar";
import Footer from "../../components/Footer/Footer";

class Layout extends Component {
  render() {
    return (
      <div>
        <Header />
        <NavigationBar />
        <Footer />
      </div>
    );
  }
}

export default Layout;
