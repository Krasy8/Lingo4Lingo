import React, { Component } from "react";
import { connect } from "react-redux";
import { Tabs } from "antd";
import "./NavigationBar.css";

import Home from "../../components/Home/Home";
import AboutUs from "../../components/AboutUs/AboutUs";
import ContactUs from "../../components/ContactUs/ContactUs";
import LogIn from "../../components/LogIn/LogIn";
import MyAccount from "../../components/MyAccount/MyAccount";

const { TabPane } = Tabs;

class NavigationBar extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userAuth: false,
    };

    this.callback = this.callback.bind(this);
    this.userAuthorisationHandler = this.userAuthorisationHandler.bind(this);
  }

  callback = (key) => {
    console.log(key);
  };

  userAuthorisationHandler = () => {
    this.setState({ userAuth: true });
  };

  render() {
    const isLoggedIn = this.props.uAuth;
    let tabs;

    if (!isLoggedIn) {
      tabs = (
        <Tabs defaultActiveKey="1" onChange={this.callback}>
          <TabPane tab="Home" key="1">
            <Home />
          </TabPane>
          <TabPane tab="About Us" key="2">
            <AboutUs />
          </TabPane>
          <TabPane tab="Contact Us" key="3">
            <ContactUs />
          </TabPane>
          <TabPane tab="Log In/Sign Up" key="4">
            <LogIn onUserAuthorisation={this.props.onUserAuth} />
          </TabPane>
        </Tabs>
      );
    } else {
      tabs = (
        <Tabs defaultActiveKey="4" onChange={this.callback}>
          <TabPane tab="Home" key="1">
            <Home />
          </TabPane>
          <TabPane tab="About Us" key="2">
            <AboutUs />
          </TabPane>
          <TabPane tab="Contact Us" key="3">
            <ContactUs />
          </TabPane>
          <TabPane tab="My Account" key="4">
            <MyAccount onLoggingOut={this.props.onUserLogOut} />
          </TabPane>
        </Tabs>
      );
    }

    return tabs;
  }
}

const mapStateToProps = (state) => {
  return {
    uAuth: state.userAuth,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    onUserAuth: () => dispatch({ type: "USER_AUTHORISATION" }),
    onUserLogOut: () => dispatch({ type: "USER_LOG_OUT" }),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(NavigationBar);
