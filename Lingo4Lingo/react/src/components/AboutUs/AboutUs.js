import React from 'react';

const aboutUs = () => (
  <section className="page-section about-heading">
    <div className="container">
      <div className="product-item">
        <div className="product-item-title d-flex">
          <div className="bg-faded p-5 d-flex ml-auto rounded">
            <h2 className="section-heading mb-0">
              <span className="section-heading-upper">Something about</span>
              <span className="section-heading-lower">What is Lingo4Lingo</span>
            </h2>
          </div>
        </div>
        <img
          className="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0"
          src="img/about.jpg"
          alt=""
        />
        <div className="product-item-description d-flex mr-auto">
          <div className="bg-faded p-5 rounded">
            <p>
              Well, the best way to explain it is through an example. Pawel is
              from Poland and has recently moved to London. His English is a bit
              patchy and he would like to improve it. Oliver is from London and
              he is learning Polish, but he never has the opportunity to listen
              and speak to native Polish speakers. Now, Pawel and Oliver could
              help each other out. For example they can meet up in a café once a
              week and have a conversation exchange, speaking half an hour in
              English and half an hour in Polish.
            </p>
            <p className="mb-0">
              There is no cost or homework involved and you learn the language
              in a social environment. Furthermore, you are more likely to learn
              slang and other things about a culture that you do not usually
              learn in a formal language class
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
                <span className="section-heading-upper">
                  TBC TBC TBC TBC TBC TBC TBC{" "}
                </span>
                <span className="section-heading-lower">
                  TBC TBC TBC TBC TBC TBC{" "}
                </span>
              </h2>
            </div>
          </div>
          <img
            className="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0"
            src="img/products-02.jpg"
            alt=""
          />
          <div className="product-item-description d-flex ml-auto">
            <div className="bg-faded p-5 rounded">
              <p className="mb-0">
                TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC
                TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC TBC
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <div className="container">
      <img
        className="img-fluid rounded about-heading-img mb-3 mb-lg-0"
        src="img/about.jpg"
        alt=""
      />
      <div className="about-heading-content">
        <div className="row">
          <div className="col-xl-9 col-lg-10 mx-auto">
            <div className="bg-faded rounded p-5">
              <h2 className="section-heading mb-4">
                <span className="section-heading-upper">Something about</span>
                <span className="section-heading-lower">
                  What is Lingo4Lingo
                </span>
              </h2>
              <p>
                Well, the best way to explain it is through an example. Pawel is
                from Poland and has recently moved to London. His English is a
                bit patchy and he would like to improve it. Oliver is from
                London and he is learning Polish, but he never has the
                opportunity to listen and speak to native Polish speakers. Now,
                Pawel and Oliver could help each other out. For example they can
                meet up in a café once a week and have a conversation exchange,
                speaking half an hour in English and half an hour in Polish.
              </p>
              <p className="mb-0">
                There is no cost or homework involved and you learn the language
                in a social environment. Furthermore, you are more likely to
                learn slang and other things about a culture that you do not
                usually learn in a formal language class
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
);

export default aboutUs;