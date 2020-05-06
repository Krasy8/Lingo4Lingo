import React, {Component} from "react";
import {Result, Button} from 'antd';


export class Step5Failure extends Component {

    startAgain = (e) => {
        e.preventDefault();
        this.props.goToStep1();
    }

    render() {
        return (
            <div style={styles.regForm}>
                <Result
                    status="error"
                    title="Submission Failed"
                    subTitle="Oops, something went wrong, try again!"
                    extra={[
                        <Button type="primary" key="console" onClick={this.startAgain}>
                            Start Again
                        </Button>
                    ]}
                >
                </Result>
            </div>
        )
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
    },
    siteResultDemoErrorIcon: {
        color: "red"
    }
};

export default Step5Failure;
