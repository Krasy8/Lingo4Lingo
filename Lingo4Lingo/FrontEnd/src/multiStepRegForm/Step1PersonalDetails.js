import React, { Component } from "react";
import {
  Form,
  Input,
  Tooltip,
  Select,
  Button,
  InputNumber,
  Typography
} 
from "antd";
import { QuestionCircleOutlined } from "@ant-design/icons";


const { Option } = Select;
const { Title } = Typography;

const formItemLayout = {
  labelCol: {
    xs: {
      span: 24,
    },
    sm: {
      span: 6,
    },
  },
  wrapperCol: {
    xs: {
      span: 24,
    },
    sm: {
      span: 16,
    },
  },
};
const tailFormItemLayout = {
  wrapperCol: {
    xs: {
      span: 24,
      offset: 0,
    },
    sm: {
      span: 10,
      offset: 8,
    },
  },
};

const styleDropdown = {
  backgroundColor: "transparent",
  backdropFilter: "blur(15px)"
}

export class Step1PersonalDetails extends Component {

  render() {
    const {
      values,
      handleChangeInput,
      handleChangeSelectAndAge,
      handleChangeCountry
    } = this.props;

    const onFinish = values => {
      console.log('Received values of form: ', values);
      this.props.nextStep();
    };

    return (

      <Form
        {...formItemLayout}
        name="registerPersonalDetails"
        initialValues={{
          login: `${values.login}`,
          password: `${values.password}`,
          email: `${values.email}`,
          gender: `${values.gender}`,
          age: `${values.age}`,
          country: `${values.country}`,
          city: `${values.city}`,
          province: `${values.province}`
        }}
        scrollToFirstError
        onFinish={onFinish}
      >
        <div className="titleDiv">
          <Title>Enter Your Personal Details</Title>
        </div>

        <Form.Item
          label={
            <span>
              Login&nbsp;
            <Tooltip title="What do you want others to call you?">
                <QuestionCircleOutlined />
              </Tooltip>
            </span>
          }
          rules={[
            {
              required: true,
              message: "Please enter your login!",
              whitespace: true,
            },
          ]}      
        >
          <Input
            onChange={handleChangeInput("login")}
          />
        </Form.Item>

        <Form.Item
          name="password"
          label="Password"
          rules={[
            {
              required: true,
              message: "Please enter your password!",
            },
          ]}
          hasFeedback
        >
          <Input.Password
            onChange={handleChangeInput("password")}

          />
        </Form.Item>

        <Form.Item
          name="confirm"
          label="Confirm Password"
          dependencies={["password"]}
          hasFeedback
          rules={[
            {
              required: true,
              message: "Please confirm your password!",
            },
            ({ getFieldValue }) => ({
              validator(rule, value) {
                if (!value || getFieldValue("password") === value) {
                  return Promise.resolve();
                }
                return Promise.reject(
                  "The two passwords that you entered do not match!"
                );
              },
            }),
          ]}
        >
          <Input.Password />
        </Form.Item>

        <Form.Item
          name="email"
          label="E-mail"
          rules={[
            {
              type: "email",
              message: "The input is not valid E-mail!",
            },
            {
              required: true,
              message: "Please enter your E-mail!",
            },
          ]}
        >
          <Input
            onChange={handleChangeInput("email")}          
          />
        </Form.Item>

        <Form.Item
          name="gender"
          label="Gender"
          rules={[
            {
              required: true,
              message: "Please select your gender!",
            },
          ]}
        >
          <Select
            onChange={handleChangeSelectAndAge("gender")}
            dropdownStyle={styleDropdown}
          >
            <Option className="optionStyle" value="MALE" >MALE</Option>
            <Option className="optionStyle" value="FEMALE" >FEMALE</Option>
            <Option className="optionStyle" value="OTHER" >OTHER</Option>
          </Select>
        </Form.Item>

        <Form.Item 
          name="age" 
          label="Age"
          rules={[
            {
              required: true,
              message: "Please enter your age!",
            },
          ]}
        >
          <InputNumber
            value={values.age}
            onChange={handleChangeSelectAndAge("age")}          
          />
        </Form.Item>

        <Form.Item 
          name="country" 
          label="Country of Residence"
          rules={[
            {
              required: true,
              message: "Please select your Country of Residence!",
            },
          ]}
        >
          <Select
            value={values.country}
            onChange={handleChangeCountry}
            showSearch
            placeholder="Select your Country of Residence"
            dropdownStyle={styleDropdown}
          >
            {values.countries.map((country) => (
              <Option
                className="optionStyle"
                key={country.value}
                value={country.value}
                style={{ color: "#1890ff" }}
              >
                {country.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item 
          name="city" 
          label="City of Residence"
          rules={[
            {
              required: true,
              message: "Please select your Country of Residence!",
            },
          ]}
        >
          <Select
            value={values.city}
            onChange={handleChangeSelectAndAge("city")}
            showSearch
            placeholder="Select your City of Residence"
            dropdownStyle={styleDropdown}
          >
            {values.cities.map((city) => (
              <Option
                className="optionStyle"
                key={city.value}
                value={city.value}
                style={{ color: "#1890ff" }}
              >
                {city.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="province" label="Province">
          <Input
            onChange={handleChangeInput("province")}
            placeholder="Enter your Province/Region/Post Code"
            className="login"
          />
        </Form.Item>

        <Form.Item {...tailFormItemLayout}>
          <Button 
            type="primary"
            htmlType="submit"            
          >
            Continue
        </Button>
        </Form.Item>
      </Form>

    );
  };
}

export default Step1PersonalDetails;
