import React from "react";
import './Header.css';

const header = () => (
  <div className="product-item-title d-flex div-main">
    <div className="bg-faded p-5 d-flex ml-auto rounded div-heading">
      <div>
        <h1 className="site-heading text-center text-white d-none d-lg-block heading-center">
          <span className="site-heading-upper text-primary mb-3">
            Learn by meeting new people
          </span>
          <span className="site-heading-lower">Lingo4Lingo</span>
        </h1>
      </div>
    </div>
  </div>
);

export default header;
