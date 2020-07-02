import React from 'react';

const contactUs = () => (
  <section className="page-section cta">
    <div className="container">
      <div className="row">
        <div className="col-xl-9 mx-auto">
          <div className="cta-inner text-center rounded">
            <h2 className="section-heading mb-5">
              <span className="section-heading-upper">
                We're Open to any suggestions
              </span>
              <span className="section-heading-lower">Contact us</span>
            </h2>
            <ul className="list-unstyled list-hours mb-5 text-left mx-auto">
              <li className="list-unstyled-item list-hours-item d-flex">
                Pawel
                <span className="ml-auto">pawel@lingo4lingo.com</span>
              </li>
              <li className="list-unstyled-item list-hours-item d-flex">
                Konrad
                <span className="ml-auto">konrad@lingo4lingo.com</span>
              </li>
              <li className="list-unstyled-item list-hours-item d-flex">
                Jakub
                <span className="ml-auto">jakub@lingo4lingo.com</span>
              </li>
            </ul>
            <p className="address mb-5">
              <em>
                <strong>1116 Orchard Street</strong>
                <br />
                Golden Valley, Minnesota
              </em>
            </p>
            <p className="mb-0">
              <small>
                <em>Call Anytime</em>
              </small>
              <br />
              (317) 585-8468
            </p>
          </div>
        </div>
      </div>
    </div>
  </section>
);

export default contactUs;