import React from 'react';
import { Link } from 'react-router-dom';

function displayAboutPage() {
    return (

        <div>
            <h1 className="site-heading text-center text-white d-none d-lg-block">
                <span className="site-heading-upper text-primary mb-3">LEARN BY MEETING NEW PEOPLE</span>
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
                            <li className="nav-item active px-lg-4">
                                <a className="nav-link text-uppercase text-expanded" href="about.html">
                                    <Link to="/about">
                                        About
                                    </Link>
                                </a>
                            </li>
                            <li className="nav-item px-lg-4">
                                <a className="nav-link text-uppercase text-expanded" href="contact.html">
                                    <Link to="/contact">
                                        Contact us
                                    </Link>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <section className="page-section about-heading">
                <div className="container">
                    <div className="product-item">
                        <div className="product-item-title d-flex">
                            <div className="bg-faded p-5 d-flex ml-auto rounded">
                                <h2 className="section-heading mb-0">
                                    <span className="section-heading-upper">Something about</span>
                                    <span className="section-heading-lower">
                                        What is Lingo4Lingo
                                    </span>
                                </h2>
                            </div>
                        </div>
                        <img className="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0" src="img/about.jpg" alt="" />
                        <div className="product-item-description d-flex mr-auto">
                            <div className="bg-faded p-5 rounded">
                                <p>
                                    Well, the best way to explain it is through an example.
                                    Pawel is from Poland and has recently moved to London. His English is a bit patchy and he would like to improve it.
                                    Oliver is from London and he is learning Polish, but he never has the opportunity to listen and speak to native Polish speakers.
                                    Now, Pawel and Oliver could help each other out. For example they can meet up in a café once a week and have a conversation exchange,
                                    speaking half an hour in English and half an hour in Polish.
                                </p>
                                <p className="mb-0">
                                    There is no cost or homework involved and you learn the language in a social environment.
                                    Furthermore, you are more likely to learn slang and other things about a culture that you do not usually learn in a formal language class
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <section className="page-section">
                    <div className="container">
                        <div className="product-item">
                            <div className="product-item-title d-flex">
                                <div className="bg-faded p-5 d-flex mr-auto rounded">
                                    <h2 className="section-heading mb-0">
                                        <span className="section-heading-upper">TBC TBC TBC TBC TBC TBC TBC </span>
                                        <span className="section-heading-lower">TBC TBC TBC TBC TBC TBC </span>
                                    </h2>
                                </div>
                            </div>
                            <img className="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0" src="img/products-02.jpg" alt="" />
                            <div className="product-item-description d-flex ml-auto">
                                <div className="bg-faded p-5 rounded">
                                    <p className="mb-0">
                                        TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <div className="container">
                    <img className="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/about.jpg" alt="" />
                    <div className="about-heading-content">
                        <div className="row">
                            <div className="col-xl-9 col-lg-10 mx-auto">
                                <div className="bg-faded rounded p-5">
                                    <h2 className="section-heading mb-4">
                                        <span className="section-heading-upper">
                                            Something about
                                        </span>
                                        <span className="section-heading-lower">
                                            What is Lingo4Lingo
                                        </span>
                                    </h2>
                                    <p>
                                        Well, the best way to explain it is through an example.
                                        Pawel is from Poland and has recently moved to London. His English is a bit patchy and he would like to improve it.
                                        Oliver is from London and he is learning Polish, but he never has the opportunity to listen and speak to native Polish speakers.
                                        Now, Pawel and Oliver could help each other out. For example they can meet up in a café once a week and have a conversation exchange,
                                        speaking half an hour in English and half an hour in Polish.
                                    </p>
                                    <p className="mb-0">
                                        There is no cost or homework involved and you learn the language in a social environment.
                                        Furthermore, you are more likely to learn slang and other things about a culture that you do not usually learn in a formal language class
                                    </p>
                                </div>
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

export default displayAboutPage;