import React, { Component } from "react";
import axios from "axios";
import moment from "moment";

import {
  Form,
  Col,
  Row,
  Input,
  notification,
  Select,
  Button,
  DatePicker,
  Tooltip,
} from "antd";
import { QuestionCircleOutlined } from "@ant-design/icons";

const { Option } = Select;

const openNotificationWithIcon = (type, placement, messageInfo, descriptionInfo) => {
  notification[type]({
    message: messageInfo,
    description: descriptionInfo,
    placement,
  });
};


class RegistrationForm extends Component {

  formRef = React.createRef();

  constructor(props) {
    super(props);
    this.state = {
      login: "",
      password: "",
      confirmPassword: "",
      email: "",
      gender: "",
      dateOfBirth: "",
      countries: [],
      countryOfResidence: "",
      cities: [],
      cityOfResidence: "",
      regionProvince: "",
      languages: [],
      languageNative1: "",
      languageNative2: "",
      languageNative3: "",
      languageSpoken1: "",
      languageSpoken2: "",
      languageSpoken3: "",
      languageSpoken4: "",
      languageSpoken5: "",
      languageToLearn: "",
      selfDescription: "",
      formSubmitted: false,
    };

    this.inputChangeHandler = this.inputChangeHandler.bind(this);
    this.selectAndAgeChangeHandler = this.selectAndAgeChangeHandler.bind(this);
    this.countryChangeHandler = this.countryChangeHandler.bind(this);
    this.cityChangeHandler = this.cityChangeHandler.bind(this);
    this.dateChangeHandler = this.dateChangeHandler.bind(this);
  }

  componentDidMount() {

    this.mountComponent();
  }

  componentDidUpdate(prevProps, prevState) {
    if (prevState.formSubmitted !== this.state.formSubmitted) {
      this.mountComponent();
    }
  }

  mountComponent = () => {
    fetch("http://localhost:8080/api/v1/user/registration/countries")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((data) => {
        let countriesFromApi = data.map((country) => {
          return { value: country, display: country };
        });
        this.setState({
          countries: [
            {
              value: "",
              display: `(Select your country of residence)`,
            },
          ].concat(countriesFromApi),
          cities: [
            {
              value: "",
              display: "(Select your city of residence)",
            },
          ],
        });
      })
      .catch((error) => {
        console.log(error);
      });

    fetch("http://localhost:8080/api/v1/user/registration/languages")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((data) => {
        let languagesFromApi = data.map((language) => {
          return { value: language, display: language };
        });
        this.setState({
          languages: [
            {
              value: "",
              display: `(Select your language)`,
            },
          ].concat(languagesFromApi),
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  // Handle fields change
  inputChangeHandler = (input) => (e) => {
    this.setState({ [input]: e.target.value });
  };

  selectAndAgeChangeHandler = (input) => (value) => {
    console.log(`selected ${value} for ${input}`);
    this.setState({ [input]: value });
    console.log("checking status of input field: " + this.state.cityOfResidence);
  };

  cityChangeHandler = (value) => {
    console.log(`selected ${value}`);
    this.setState({ cityOfResidence: value });
  };

  countryChangeHandler = (value) => {
    console.log(`selected ${value}`);
    this.setState(
      {
        countryOfResidence: value,
      },
      () => {
        fetch(`http://localhost:8080/api/v1/user/registration/cities/${value}`)
          .then((response) => {
            console.log(response);
            return response.json();
          })
          .then((data) => {
            let citiesFromApi = data.map((city) => {
              return { value: city, display: city };
            });
            this.setState({
              cities: [
                {
                  value: "",
                  display: "Select your city of residence",
                },
              ].concat(citiesFromApi),
              cityOfResidence: "",
            });
            this.formRef.current.setFieldsValue({cityOfResidence: ""});
          })
          .catch((error) => {
            console.log(error);
          });
      }
    );
  };

  dateChangeHandler = (date, dateString) => {
    console.log(date, dateString);
    this.setState({dateOfBirth: dateString});
  }

  onSubmit = () => {
    const {
        login,
        password,
        email,
        gender,
        dateOfBirth,
        countryOfResidence,
        cityOfResidence,
        regionProvince,
        languageNative1,
        languageNative2,
        languageNative3,
        languageSpoken1,
        languageSpoken2,
        languageSpoken3,
        languageSpoken4,
        languageSpoken5,
        languageToLearn,
        selfDescription,
    } = this.state;

    axios
      .post("http://localhost:8080/api/v1/user/registration/newUser", {
        login,
        password,
        email,
        gender,
        dateOfBirth,
        countryOfResidence,
        cityOfResidence,
        regionProvince,
        languageNative1,
        languageNative2,
        languageNative3,
        languageSpoken1,
        languageSpoken2,
        languageSpoken3,
        languageSpoken4,
        languageSpoken5,
        languageToLearn,
        selfDescription,
      })
      .then((response) => {
        console.log(response);
        openNotificationWithIcon(
          "success",
          'topLeft',
          "Successfull Registration!", 
          "Welcome to Lingo4Lingo!"
          );
          this.props.clsDrawer();
          this.formRef.current.resetFields();
          this.clearForm();
          // this.setState({formSubmitted: true});
      })
      .catch((error) => {
        console.log(error);
        openNotificationWithIcon(
          "error",
          'topLeft',
          "Registration Error",
          "Oops, something went wrong with your registration, please try again!"
        );
      });
  };

  clearForm = () => {
    this.formRef.current.setFieldsValue({
      login: "",
      password: "",
      confirmPassword: "",
      email: "",
      gender: "",
      dateOfBirth: "",
      countryOfResidence: "",
      cityOfResidence: "",
      regionProvince: "",
      languageNative1: "",
      languageNative2: "",
      languageNative3: "",
      languageSpoken1: "",
      languageSpoken2: "",
      languageSpoken3: "",
      languageSpoken4: "",
      languageSpoken5: "",
      languageToLearn: "",
      selfDescription: "",
    });
    this.setState({
      login: "",
      password: "",
      confirmPassword: "",
      email: "",
      gender: "",
      dateOfBirth: "",
      countries: [],
      countryOfResidence: "",
      cities: [],
      cityOfResidence: "",
      regionProvince: "",
      languages: [],
      languageNative1: "",
      languageNative2: "",
      languageNative3: "",
      languageSpoken1: "",
      languageSpoken2: "",
      languageSpoken3: "",
      languageSpoken4: "",
      languageSpoken5: "",
      languageToLearn: "",
      selfDescription: "",
      formSubmitted: true,
    });
  }

  render() {

    const onFinish = (values) => {
      console.log("Received values of form: ", values);
      fetch(
        `http://localhost:8080/api/v1/user/registration/isEmailTaken/${values.email}`
      )
        .then((response) => {
          console.log(response);
          return response.json();
        })
        .then((data) => {
          data === true
            ? openNotificationWithIcon(
                "error",
                'topLeft',
                "Email Error",
                "The email you have entered is already in use, please choose a different one!"
              )
            : this.onSubmit();
        })
        .catch((error) => {
          console.log(error);
        });
    };

    return (
      <Form
        ref={this.formRef}
        layout="vertical"
        initialValues={{
          login: `${this.state.login}`,
          password: `${this.state.password}`,
          email: `${this.state.email}`,
          gender: `${this.state.gender}`,
          countryOfResidence: `${this.state.countryOfResidence}`,
          cityOfResidence: `${this.state.cityOfResidence}`,
          regionProvince: `${this.state.regionProvince}`,
          languageNative1: `${this.state.languageNative1}`,
          languageNative2: `${this.state.languageNative2}`,
          languageNative3: `${this.state.languageNative3}`,
          languageSpoken1: `${this.state.languageSpoken1}`,
          languageSpoken2: `${this.state.languageSpoken2}`,
          languageSpoken3: `${this.state.languageSpoken3}`,
          languageSpoken4: `${this.state.languageSpoken4}`,
          languageSpoken5: `${this.state.languageSpoken5}`,
          languageToLearn: `${this.state.languageToLearn}`,
          selfDescription: `${this.state.selfDescription}`,
        }}
        scrollToFirstError
        onFinish={onFinish}
      >
        <Row gutter={16}>
          <Col span={12}>
            <Form.Item
              name="login"
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
              <Input onChange={this.inputChangeHandler("login")} />
            </Form.Item>
          </Col>
          <Col span={12}>
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
                value={this.state.languageNative1}
                onChange={this.selectAndAgeChangeHandler("languageNative1")}
                showSearch
                placeholder="Select your Native Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
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
              <Input.Password onChange={this.inputChangeHandler("password")} />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="languageNative2" label="Native Language 2">
              <Select
                value={this.state.languageNative2}
                onChange={this.selectAndAgeChangeHandler("languageNative2")}
                showSearch
                placeholder="Select your second Native Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item
              name="confirmPassword"
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
          </Col>
          <Col span={12}>
            <Form.Item name="languageNative3" label="Native Language 3">
              <Select
                value={this.state.languageNative3}
                onChange={this.selectAndAgeChangeHandler("languageNative3")}
                showSearch
                placeholder="Select your third Native Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
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
              <Input onChange={this.inputChangeHandler("email")} />
            </Form.Item>
          </Col>
          <Col span={12}>
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
                value={this.state.languageNative1}
                onChange={this.selectAndAgeChangeHandler("languageSpoken1")}
                showSearch
                placeholder="Select your Spoken Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
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
              <Select onChange={this.selectAndAgeChangeHandler("gender")}>
                <Option className="optionStyle" value="MALE">
                  MALE
                </Option>
                <Option className="optionStyle" value="FEMALE">
                  FEMALE
                </Option>
                <Option className="optionStyle" value="OTHER">
                  OTHER
                </Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="languageSpoken2" label="Spoken Language 2">
              <Select
                value={this.state.languageSpoken2}
                onChange={this.selectAndAgeChangeHandler("languageSpoken2")}
                showSearch
                placeholder="Select your second Spoken Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item
              name="dateOfBirth"
              label="Date of Birth"
              rules={[
                {
                  required: true,
                  message: "Please enter your date of birth!",
                },
              ]}
            >
              <DatePicker
                onChange={this.dateChangeHandler}
                value={moment(this.state.dateOfBirth)}
                placeholder="Select date"
                style={{ width: "100%" }}
              />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="languageSpoken3" label="Spoken Language 3">
              <Select
                value={this.state.languageSpoken3}
                onChange={this.selectAndAgeChangeHandler("languageSpoken3")}
                showSearch
                placeholder="Select your third Spoken Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item
              name="countryOfResidence"
              label="Country of Residence"
              shouldUpdate
              rules={[
                {
                  required: true,
                  message: "Please select your Country of Residence!",
                },
              ]}
            >
              <Select
                value={this.state.countryOfResidence}
                onChange={this.countryChangeHandler}
                showSearch
                placeholder="Select your Country of Residence"
              >
                {this.state.countries.map((country) => (
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
          </Col>
          <Col span={12}>
            <Form.Item name="languageSpoken4" label="Spoken Language 4">
              <Select
                value={this.state.languageSpoken4}
                onChange={this.selectAndAgeChangeHandler("languageSpoken4")}
                showSearch
                placeholder="Select your fourth Spoken Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item
              name="cityOfResidence"
              label="City of Residence"
              shouldUpdate
              rules={[
                {
                  required: true,
                  message: "Please select your City of Residence!",
                },
              ]}
            >
              <Select
                value={this.state.cityOfResidence}
                onChange={this.cityChangeHandler}
                showSearch
                placeholder="(Select your City of Residence)"
              >
                {this.state.cities.map((city) => (
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
          </Col>
          <Col span={12}>
            <Form.Item name="languageSpoken5" label="Spoken Language 5">
              <Select
                value={this.state.languageSpoken5}
                onChange={this.selectAndAgeChangeHandler("languageSpoken5")}
                showSearch
                placeholder="Select your fifth Spoken Language"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="regionProvince" label="Region/Province">
              <Input
                onChange={this.inputChangeHandler("regionProvince")}
                placeholder="Enter your Region/Province/Post Code"
                className="login"
              />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item
              name="languageToLearn"
              label="Language To Learn"
              rules={[
                {
                  required: true,
                  message:
                    "Please select the language you would like to learn!",
                },
              ]}
            >
              <Select
                value={this.state.languageToLearn}
                onChange={this.selectAndAgeChangeHandler("languageToLearn")}
                showSearch
                placeholder="Select the language you would like to learn next!"
                onSearch={this.onSearch}
              >
                {this.state.languages.map((language) => (
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
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={24}>
            <Form.Item name="selfDescription" label="Self-Description">
              <Input.TextArea
                rows={4}
                onChange={this.inputChangeHandler("selfDescription")}
                placeholder="Tell us more about yourself"
              />
            </Form.Item>
            <Form.Item>
              <Button onClick={this.props.clsDrawer} style={{ marginRight: 8 }}>
                Cancel
              </Button>
              <Button type="primary" htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Col>
        </Row>
      </Form>
    );
  }
}

export default RegistrationForm;
