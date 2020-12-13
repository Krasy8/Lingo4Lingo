import React, { Component } from "react";

import AuthenticationService from "../../services/auth/AuthenticationService";

class MyAccount extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userDetails: {
        login: "",
        cityOfResidence: "",
        languageToLearn: "",
      },
    };

    this.logOutBtnHandler = this.logOutBtnHandler.bind(this);
  }

  logOutBtnHandler = () => {
    AuthenticationService.logout();
    this.props.onLoggingOut();
  };

  render() {
    const userName = AuthenticationService.getLoggedUserName();
    return (
      <section className="page-section cta">
        <div className="container">
          <div className="intro-text left-0 text-center bg-faded p-5 rounded">
            <h2 className="section-heading mb-4">
              <span className="section-heading-upper">
                Hello there {userName}!
              </span>
              <span className="section-heading-lower">
                welcome to lingo4lingo!
              </span>
            </h2>
            <div className="intro-button mx-auto">
              <button
                className="btn btn-primary btn-xl"
                onClick={this.logOutBtnHandler}
              >
                Log Out!
              </button>
            </div>
          </div>
        </div>
      </section>
    );
  }
}

export default MyAccount;
