import React from 'react';
import { Tabs } from "antd";
import "./NavigationBar.css";

import Home from '../../components/Home/Home';
import AboutUs from '../../components/AboutUs/AboutUs';
import ContactUs from '../../components/ContactUs/ContactUs';
import LogIn from '../../components/LogIn/LogIn';

const { TabPane } = Tabs;

function callback(key) {
  console.log(key);
}

const navigationBar = () => (
  <Tabs defaultActiveKey="1" onChange={callback}>
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
      <LogIn />
    </TabPane>
  </Tabs>
);

export default navigationBar;
