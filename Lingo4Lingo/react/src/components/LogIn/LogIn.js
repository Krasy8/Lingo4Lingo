import React, { Component } from "react";
import { Form, Input, Button, Checkbox, notification } from "antd";
import "./LogIn.css";

import RegSideDrawer from "../RegSideDrawer/RegSideDrawer";
import RegistrationForm from "../RegSideDrawer/RegistrationForm/RegistrationForm";
import AuthenticationService from "../../services/auth/AuthenticationService";

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

const openNotificationWithIcon = (
  type,
  placement,
  messageInfo,
  descriptionInfo
) => {
  notification[type]({
    message: messageInfo,
    description: descriptionInfo,
    placement,
  });
};

class LogIn extends Component {
  constructor(props) {
    super(props);

    this.state = {
      authenticated: false,
    };

    this.onFinish = this.onFinish.bind(this);
    this.onFinishFailed = this.onFinishFailed.bind(this);
  }

  onFinish = (values) => {
    AuthenticationService.executeBasicAuthenticationService(
      values.username,
      values.password
    )
      .then(() => {
        AuthenticationService.registerSuccessfulLogin(
          values.username,
          values.password
        );
        this.setState({ authenticated: true });
        this.props.onUserAuthorisation();

        console.log("Success:", values);
      })
      .catch((error) => {
        // console.log(error);
        AuthenticationService.registrationUnsuccessfulLogin(
          values.username,
          values.password
        );
        this.onFinishFailed(error);
      });
  };

  onFinishFailed = (errorInfo) => {
    console.log("Failed:", errorInfo);
    openNotificationWithIcon(
      "error",
      "topLeft",
      "Authentication Error",
      "Provided login and/or password were incorrect! Please try again."
    );
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
                  <span className="section-heading-lower">
                    Enter Lingo4Lingo!
                  </span>
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
