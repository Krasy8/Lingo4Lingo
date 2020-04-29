import React, { Component } from "react";
// import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
// import AppBar from "material-ui/AppBar";
import { Result, Button } from 'antd';

export class Step4Success extends Component {
  continue = (e) => {
    e.preventDefault();
    // PROCESS FORM - SEND TO BACKEND!
    this.props.nextStep();
  };

  back = (e) => {
    e.preventDefault();
    this.props.prevStep();
  };

  render() {

    return (
      <div style={styles.regForm}>
        {/* <MuiThemeProvider>
          <React.Fragment>
            <AppBar title="Success" />
                <h1>Thank You For Joining Lingo4Lingo!</h1>
          </React.Fragment>
        </MuiThemeProvider> */}
        <Result
          status="success"
          title="Thank you for joining Lingo4Lingo!"
          subTitle="We wish you good luck with learning new languages!"
          extra={[
            <Button type="primary" key="console">
              Your Account
            </Button>
            // <Button key="buy">Buy Again</Button>,
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
    margin: "10px auto",
    width: "80%",
    display: "block",
    backgroundColor: "white",
    paddingBottom: "30px",
  },
};

export default Step4Success;
