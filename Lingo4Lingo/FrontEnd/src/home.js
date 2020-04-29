import React from 'react';
import { Link } from 'react-router-dom';

function displayHomePage() {
    return (
      <div className="App">
        <h1 className="site-heading text-center text-white d-none d-lg-block">
          <span className="site-heading-upper text-primary mb-3">
            Learn by meeting new people
          </span>
          <span className="site-heading-lower">Lingo4Lingo</span>
        </h1>

        <nav
          className="navbar navbar-expand-lg navbar-dark py-lg-4"
          id="mainNav"
        >
          <div className="container">
            {/* <a
              className="navbar-brand text-uppercase text-expanded font-weight-bold  d-lg-none"
              href="#"
            >
              Meet people
            </a> */}
            <button
              className="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarResponsive"
              aria-controls="navbarResponsive"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarResponsive">
              <ul className="navbar-nav mx-auto">
                <li className="nav-item active px-lg-4">
                  <a
                    className="nav-link text-uppercase text-expanded"
                    href="index.html"
                  >
                    <Link to="/">Home</Link>
                    <span className="sr-only">(current)</span>
                  </a>
                </li>
                <li className="nav-item px-lg-4">
                  <a
                    className="nav-link text-uppercase text-expanded"
                    href="about.html"
                  >
                    <Link to="/about">About</Link>
                  </a>
                </li>
                <li className="nav-item px-lg-4">
                  <a
                    className="nav-link text-uppercase text-expanded"
                    href="contact.html"
                  >
                    <Link to="/contact">Contact us</Link>
                  </a>
                </li>
                <li className="nav-item px-lg-4">
                  <a
                    className="nav-link text-uppercase text-expanded"
                    href="contact.html"
                  >
                    <Link to="/register">Sign up!</Link>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>

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
                <div className="intro-button mx-auto">
                  <a className="btn btn-primary btn-xl" href="/register">
                    Join Us Today!
                  </a>
                </div>
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
                    <span className="section-heading-lower">What it is</span>
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

        <footer className="footer text-faded text-center py-5">
          <div className="container">
            <p className="m-0 small">Copyright & copy; Lingo4Lingo 2020</p>
          </div>
        </footer>
      </div>
    );
}

export default displayHomePage;