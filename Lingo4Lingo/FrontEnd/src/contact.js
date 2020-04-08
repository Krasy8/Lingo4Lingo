import React from 'react';
import { Link } from 'react-router-dom';

function displayContactPage() {
    return (
        <div>
            <h1 className="site-heading text-center text-white d-none d-lg-block">
                <span className="site-heading-upper text-primary mb-3">
                    LEARN BY MEETING NEW PEOPLE
                </span>
                <span className="site-heading-lower">LINGO4LINGO</span>
            </h1>

            <nav className="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
                <div className="container">
                    {/* <a className="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">
                        Start Bootstrap
                    </a> */}
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarResponsive">
                        <ul className="navbar-nav mx-auto">
                            <li className="nav-item px-lg-4">
                                <a className="nav-link text-uppercase text-expanded" href="index.html">
                                    <Link to="/">
                                        Home
                                    </Link>
                                    <span className="sr-only">(current)</span>
                                </a>
                            </li>
                            <li className="nav-item px-lg-4">
                                <a className="nav-link text-uppercase text-expanded" href="about.html">
                                    <Link to="/about">
                                        About
                                    </Link>
                                </a>
                            </li>         
                            <li className="nav-item active px-lg-4">
                                <a className="nav-link text-uppercase text-expanded" href="store.html">
                                    <Link to="/contact">
                                        Contact us
                                    </Link>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <section className="page-section cta">
                <div className="container">
                    <div className="row">
                        <div className="col-xl-9 mx-auto">
                            <div className="cta-inner text-center rounded">
                                <h2 className="section-heading mb-5">
                                    <span className="section-heading-upper">
                                        We're Open to any suggestions
                                    </span>
                                    <span className="section-heading-lower">
                                        Contact us
                                    </span>
                                </h2>
                                <ul className="list-unstyled list-hours mb-5 text-left mx-auto">
                                    <li className="list-unstyled-item list-hours-item d-flex">
                                        Pawel 
                                        <span className="ml-auto">
                                            pawel@lingo4lingo.com
                                        </span>
                                    </li>
                                    <li className="list-unstyled-item list-hours-item d-flex">
                                        Konrad
                                        <span className="ml-auto">
                                            konrad@lingo4lingo.com
                                        </span>
                                    </li>
                                    <li className="list-unstyled-item list-hours-item d-flex">
                                        Jakub
                                        <span className="ml-auto">
                                            jakub@lingo4lingo.com
                                        </span>
                                    </li>
                                </ul>
                                <p className="address mb-5">
                                    <em>
                                        <strong>1116 Orchard Street</strong>
                                        <br/>
                                        Golden Valley, Minnesota
                                    </em>
                                </p>
                                <p className="mb-0">
                                    <small>
                                        <em>Call Anytime</em>
                                    </small>
                                    <br/>
                                    (317) 585-8468
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <footer className="footer text-faded text-center py-5">
                <div clasName="container">
                    <p className="m-0 small">Copyright & copy; Lingo4Lingo 2020</p>
                </div>
            </footer>
        </div>
    );
};

export default displayContactPage;