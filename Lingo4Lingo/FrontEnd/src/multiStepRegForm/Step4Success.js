import React, { Component } from "react";
import { Result, Button } from 'antd';

export class Step4Success extends Component {

  render() {

    return (
      <div style={styles.regForm}>
        <Result
          status="success"
          title="Thank you for joining Lingo4Lingo!"
          subTitle="We wish you good luck with learning new languages!"
          extra={[
            <Button type="primary" key="console">
              Your Account
            </Button>
          ]}
          className="result"
        />
      </div>
    );
  }
}

const styles = {
  button: {
    margin: 15,
  },
  regForm: {
    margin: "auto",
    width: "80%",
    display: "block",
    backgroundColor: "transparent",
    // paddingBottom: "30px",
  }
};

export default Step4Success;
