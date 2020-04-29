import React, { Component } from "react";
import { 
  List, 
  Typography, 
  Divider, 
  Button 
} from 'antd';
import axios from 'axios';

const { Title } = Typography;

export class Step3Confirmation extends Component {
  continue = (e) => {
    e.preventDefault();
    // PROCESS FORM - SEND TO BACKEND!
    const {
      values: {
        login,
        password,
        email,
        gender,
        age,
        country,
        city,
        province,
        languageNative1,
        languageNative2,
        languageNative3,
        languageSpoken1,
        languageSpoken2,
        languageSpoken3,
        languageSpoken4,
        languageSpoken5,
        languageToLearn,
        selfDescription
      }
    } = this.props;

    axios.post("http://localhost:8080/user", 
    {
      login,
      password,
      email,
      gender,
      age,
      country,
      city,
      province,
      languageNative1,
      languageNative2,
      languageNative3,
      languageSpoken1,
      languageSpoken2,
      languageSpoken3,
      languageSpoken4,
      languageSpoken5,
      languageToLearn,
      selfDescription
    }).then(response => {
      console.log(response)
    })
    .catch(error => {
      console.log(error)
    })

    this.props.nextStep();
  };

  back = (e) => {
    e.preventDefault();
    this.props.prevStep();
  };

  render() {
    const {
      values: {
        login,
        email,
        gender,
        age,
        country,
        city,
        province,
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
      },
    } = this.props;

    return (
      <div className="step3regForm">

        <div className="titleDiv">
          <Title>Final Check</Title>
        </div>

        <List
          header={<div>Check Your Personal Details</div>}
          bordered
        >
          <List.Item>
            <Typography.Text code>Login: </Typography.Text> {login}
          </List.Item>
          <List.Item>
            <Typography.Text code>Email: </Typography.Text> {email}
          </List.Item>
          <List.Item>
            <Typography.Text code>Gender: </Typography.Text> {gender}
          </List.Item>
          <List.Item>
            <Typography.Text code>Age: </Typography.Text> {age}
          </List.Item>
          <List.Item>
            <Typography.Text code>Country of Residence: </Typography.Text>
            {country}
          </List.Item>
          <List.Item>
            <Typography.Text code>City of Residence: </Typography.Text> {city}
          </List.Item>
          <List.Item>
            <Typography.Text code>Province: </Typography.Text> {province}
          </List.Item>
        </List>

        <Divider orientation="left"></Divider>

        <List
          header={<div>Check Your Language Details</div>}
          bordered
        >
          <List.Item>
            <Typography.Text code>Native Language: </Typography.Text>{" "}
            {languageNative1}
          </List.Item>
          <List.Item>
            <Typography.Text code>Second Native Language: </Typography.Text>{" "}
            {languageNative2}
          </List.Item>
          <List.Item>
            <Typography.Text code>Third Native Language: </Typography.Text>{" "}
            {languageNative3}
          </List.Item>
          <List.Item>
            <Typography.Text code>Spoken Language: </Typography.Text>{" "}
            {languageSpoken1}
          </List.Item>
          <List.Item>
            <Typography.Text code>Second Spoken Language: </Typography.Text>{" "}
            {languageSpoken2}
          </List.Item>
          <List.Item>
            <Typography.Text code>Third Spoken Language: </Typography.Text>{" "}
            {languageSpoken3}
          </List.Item>
          <List.Item>
            <Typography.Text code>Fourth Spoken Language: </Typography.Text>{" "}
            {languageSpoken4}
          </List.Item>
          <List.Item>
            <Typography.Text code>Fifth Spoken Language: </Typography.Text>{" "}
            {languageSpoken5}
          </List.Item>
          <List.Item>
            <Typography.Text code>
              Your Next Language to Learn:{" "}
            </Typography.Text>{" "}
            {languageToLearn}
          </List.Item>
          <List.Item>
            <Typography.Text code>Self-Description: </Typography.Text>{" "}
            {selfDescription}
          </List.Item>
        </List>

        <div className="confirmFooter">
          <Button type="primary" danger onClick={this.back}>
            Back
          </Button>
          <Button type="primary" onClick={this.continue}>
            Submit
          </Button>
        </div>

      </div>
    );
  }
}

export default Step3Confirmation;
