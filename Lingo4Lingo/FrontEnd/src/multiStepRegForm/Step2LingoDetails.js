import React, { Component } from "react";
import { 
  Form, 
  Select, 
  Button,
  Input,
  Typography 
} from "antd";

const { Option } = Select;
const { TextArea } = Input;
const { Title } = Typography;

function onSearch(val) {
  console.log("search:", val);
}

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
  color: "white",
  backdropFilter: "blur(15px)",
};

export class Step2LingoDetails extends Component {

  back = (e) => {
    e.preventDefault();
    this.props.prevStep();
  };

  render() {
    const { 
      values, 
      handleChangeSelectAndAge, 
      handleChangeInput 
    } = this.props;

    const onFinish = (values) => {
      console.log("Received values of form: ", values);
      this.props.nextStep();
    };
    
    return (
      <Form
        {...formItemLayout}
        initialValues={{
          languageNative1: `${values.languageNative1}`,
          languageNative2: `${values.languageNative2}`,
          languageNative3: `${values.languageNative3}`,
          languageSpoken1: `${values.languageSpoken1}`,
          languageSpoken2: `${values.languageSpoken2}`,
          languageSpoken3: `${values.languageSpoken3}`,
          languageSpoken4: `${values.languageSpoken4}`,
          languageSpoken5: `${values.languageSpoken5}`,
          languageToLearn: `${values.languageToLearn}`,
          selfDescription: `${values.selfDescription}`,
        }}
        scrollToFirstError
        onFinish={onFinish}
      >
        <div className="titleDiv">
          <Title>Enter Your Language Details</Title>
        </div>

        <Form.Item
          name="languageNative1"
          label="Native Language 1"
          rules={[
            {
              required: true,
              message: "Please select your Native Language!",
            },
          ]}
        >
          <Select
            value={values.languageNative1}
            onChange={handleChangeSelectAndAge("languageNative1")}
            showSearch
            placeholder="Select your Native Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="languageNative2" label="Native Language 2">
          <Select
            value={values.languageNative2}
            onChange={handleChangeSelectAndAge("languageNative2")}
            showSearch
            placeholder="Select your second Native Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="languageNative3" label="Native Language 3">
          <Select
            value={values.languageNative3}
            onChange={handleChangeSelectAndAge("languageNative3")}
            showSearch
            placeholder="Select your third Native Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item
          name="languageSpoken1"
          label="Spoken Language 1"
          rules={[
            {
              required: true,
              message: "Please select your main Spoken Language!",
            },
          ]}
        >
          <Select
            value={values.languageNative1}
            onChange={handleChangeSelectAndAge("languageSpoken1")}
            showSearch
            placeholder="Select your Spoken Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="languageSpoken2" label="Spoken Language 2">
          <Select
            value={values.languageSpoken2}
            onChange={handleChangeSelectAndAge("languageSpoken2")}
            showSearch
            placeholder="Select your second Spoken Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="languageSpoken3" label="Spoken Language 3">
          <Select
            value={values.languageSpoken3}
            onChange={handleChangeSelectAndAge("languageSpoken3")}
            showSearch
            placeholder="Select your third Spoken Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="languageSpoken4" label="Spoken Language 4">
          <Select
            value={values.languageSpoken4}
            onChange={handleChangeSelectAndAge("languageSpoken4")}
            showSearch
            placeholder="Select your fourth Spoken Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="languageSpoken5" label="Spoken Language 5">
          <Select
            value={values.languageSpoken5}
            onChange={handleChangeSelectAndAge("languageSpoken5")}
            showSearch
            placeholder="Select your fifth Spoken Language"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item
          name="languageToLearn"
          label="Language To Learn"
          rules={[
            {
              required: true,
              message: "Please select the language you would like to learn!",
            },
          ]}
        >
          <Select
            value={values.languageToLearn}
            onChange={handleChangeSelectAndAge("languageToLearn")}
            showSearch
            placeholder="Select the language you would like to learn next!"
            onSearch={onSearch}
            dropdownStyle={styleDropdown}
          >
            {values.languages.map((language) => (
              <Option
                className="optionStyle"
                key={language.value}
                value={language.value}
              >
                {language.display}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="selfDescription" label="Self-Description">
          <TextArea
            onChange={handleChangeInput("selfDescription")}
            placeholder="Tell us more about yourself"
          />
        </Form.Item>

        <Form.Item {...tailFormItemLayout}>
          <Button type="primary" danger onClick={this.back}>
            Back
          </Button>
          <Button 
            type="primary"
            htmlType="submit"            
          >
            Continue
          </Button>
        </Form.Item>
      </Form>
    );
  } 
}

export default Step2LingoDetails;
