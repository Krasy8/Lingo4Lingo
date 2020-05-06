import React, { Component } from "react";
import { Select } from "antd";

const { Option } = Select;

class LocationComponentTest extends Component {
  state = {
    countries: [],
    citiesByCountry: [],
    citySelected: "",
  };

  componentDidMount() {
    let countriesFromApiTest = fetch("http://localhost:8080/api/countries")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((data) => {
        data.map((country) => {
          return { value: country };
        });
      });
      
    this.setState({
      countries: countriesFromApiTest,
    });
  }

  citiesByCountryFromApi = (value) => {
    fetch(`http://localhost:8080/api/cities/${value}`)
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((data) => {
        data.map((city) => {
          return { value: city };
        });
      })
      .catch((error) => {
      console.log(error);
    });
    this.setState({
        citiesByCountry
    })
  };
    
}

export default LocationComponentTest;
