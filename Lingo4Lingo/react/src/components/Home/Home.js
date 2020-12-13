import React, { Component } from "react";
import { connect } from "react-redux";

import RegSideDrawer from "../RegSideDrawer/RegSideDrawer";
import RegistrationForm from "../RegSideDrawer/RegistrationForm/RegistrationForm";

class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userAuth: false,
    };
  }
  render() {
    const isLoggedIn = this.props.uAuth;
    let joinUsBtn;

    if (!isLoggedIn) {
      joinUsBtn = (
        <div className="intro-button mx-auto">
          <button
            className="btn btn-primary btn-xl"
            onClick={() => this.sideDrawerHome.showDrawer()}
          >
            Join Us Today!
          </button>
        </div>
      );
    } else {
      joinUsBtn = null;
    }

    return (
      <div>
        <section className="page-section clearfix">
          <div className="container">
            <div className="intro">
              <img
                className="intro-img img-fluid mb-3 mb-lg-0 rounded"
                src="img/intro.jpg"
                alt=""
              />
              <div className="intro-text left-0 text-center bg-faded p-5 rounded">
                <h2 className="section-heading mb-4">
                  <span className="section-heading-upper">
                    Want to learn languages
                  </span>
                  <span className="section-heading-lower">
                    from native speakers?
                  </span>
                </h2>
                <p className="mb-3">
                  Do you want to learn a new language, do you need new
                  interesting people. Set up an account with us and Meet them!
                </p>
                {/* <div className="intro-button mx-auto">
                  <button
                    className="btn btn-primary btn-xl"
                    onClick={() => this.sideDrawerHome.showDrawer()}
                  >
                    Join Us Today!
                  </button>
                </div> */}
                {joinUsBtn}
                <RegSideDrawer
                  ref={(instance) => {
                    this.sideDrawerHome = instance;
                  }}
                >
                  <RegistrationForm />
                </RegSideDrawer>
              </div>
            </div>
          </div>
        </section>

        <section className="page-section cta">
          <div className="container">
            <div className="row">
              <div className="col-xl-9 mx-auto">
                <div className="cta-inner text-center rounded">
                  <h2 className="section-heading mb-4">
                    <span className="section-heading-upper">Lingo4Lingo</span>
                    <span className="section-heading-lower">What is it?</span>
                  </h2>
                  <p className="mb-0">
                    Well, the best way to explain it is through an example.
                    Pawel is from Poland and has recently moved to London. His
                    English is a bit patchy and he would like to improve it.
                    Oliver is from London and he is learning Polish, but he
                    never has the opportunity to listen and speak to native
                    Polish speakers. Now, Pawel and Oliver could help each other
                    out. For example they can meet up in a café once a week and
                    have a conversation exchange, speaking half an hour in
                    English and half an hour in Polish. There is no cost or
                    homework involved and you learn the language in a social
                    environment. Furthermore, you are more likely to learn slang
                    and other things about a culture that you do not usually
                    learn in a formal language class.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    uAuth: state.userAuth,
  };
};

export default connect(mapStateToProps)(Home);
