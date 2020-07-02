import React, { Component } from "react";
import { Drawer } from "antd";
import "./RegSideDrawer.css";

import RegistrationForm from "./RegistrationForm/RegistrationForm";

class RegSideDrawer extends Component {
  state = {
    drawerVisible: false,
  };

  showDrawer = () => {
    this.setState({
      drawerVisible: true,
    });
  };

  closeDrawer = () => {
    this.setState({
      drawerVisible: false,
    });
  };

  render() {
    return (
      <Drawer
        title="Create a new account"
        width={720}
        onClose={this.closeDrawer}
        visible={this.state.drawerVisible}
        bodyStyle={{ paddingBottom: 80 }}
      >
        <RegistrationForm
          clsDrawer={this.closeDrawer}
        />
      </Drawer>
    );
  }
}

export default RegSideDrawer;
