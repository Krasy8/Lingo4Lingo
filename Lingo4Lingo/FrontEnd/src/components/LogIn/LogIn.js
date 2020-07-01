import React, { Component } from "react";
import { Form, Input, Button, Checkbox } from "antd";
import './LogIn.css';

import RegSideDrawer from '../RegSideDrawer/RegSideDrawer'
import RegistrationForm from "../RegSideDrawer/RegistrationForm/RegistrationForm";

const layout = {
  labelCol: {
    span: 8,
  },
  wrapperCol: {
    span: 8,
  },
};
const tailLayout = {
  wrapperCol: {
    offset: 8,
    span: 8,
  },
};

class LogIn extends Component {
 
  onFinish = (values) => {
    console.log("Success:", values);
  };

  onFinishFailed = (errorInfo) => {
    console.log("Failed:", errorInfo);
  };

  render() {
    return (
      <section className="page-section cta">
        <div className="container">
          <div className="row">
            <div className="col-xl-9 mx-auto">
              <div className="cta-inner text-center rounded">
                <h2 className="section-heading mb-5">
                  {/* <span className="section-heading-upper">
                    Hello There!
                  </span> */}
                  <span className="section-heading-lower">Enter Lingo4Lingo!</span>
                </h2>
                <div className="formDiv">
                  <Form
                    {...layout}
                    name="basic"
                    initialValues={{
                      remember: true,
                    }}
                    onFinish={this.onFinish}
                    onFinishFailed={this.onFinishFailed}
                  >
                    <Form.Item
                      label="Login"
                      name="username"
                      rules={[
                        {
                          required: true,
                          message: "Please input your username!",
                        },
                      ]}
                    >
                      <Input />
                    </Form.Item>

                    <Form.Item
                      label="Password"
                      name="password"
                      rules={[
                        {
                          required: true,
                          message: "Please input your password!",
                        },
                      ]}
                    >
                      <Input.Password />
                    </Form.Item>

                    <Form.Item
                      {...tailLayout}
                      name="remember"
                      valuePropName="checked"
                    >
                      <Checkbox>Remember me</Checkbox>
                    </Form.Item>

                    <Form.Item {...tailLayout}>
                      <div className="div-btns">
                        <Button
                          type="primary"
                          htmlType="submit"
                          className="Button"
                        >
                          Log In
                        </Button>
                        <Button
                          onClick={() => this.sideDrawerLogin.showDrawer()}
                          className="Button"
                        >
                          Sign Up
                        </Button>
                      </div>
                      <RegSideDrawer
                        ref={(instance) => {
                          this.sideDrawerLogin = instance;
                        }}
                      >
                        <RegistrationForm />
                      </RegSideDrawer>
                    </Form.Item>
                  </Form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    );
  }
}

export default LogIn;
