/* eslint-disable default-case */
import React, {Component} from "react";
import Step1PersonalDetails from "./Step1PersonalDetails";
import Step2LingoDetails from "./Step2LingoDetails";
import Step3Confirmation from "./Step3Confirmation";
import Step4Success from "./Step4Success";
import Step5Failure from "./Step5Failure";

export class UserForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            step: 1,
            login: "",
            password: "",
            confirmPassword: "",
            email: "",
            gender: "",
            age: "",
            countries: [],
            country: "",
            cities: [],
            city: "",
            province: "",
            languages: [],
            languageNative1: "",
            languageNative2: "",
            languageNative3: "",
            languageSpoken1: "",
            languageSpoken2: "",
            languageSpoken3: "",
            languageSpoken4: "",
            languageSpoken5: "",
            languageToLearn: "",
            selfDescription: ""
        };
        this.handleChangeInput = this.handleChangeInput.bind(this);
        this.handleChangeSelectAndAge = this.handleChangeSelectAndAge.bind(this);
        this.handleChangeCountry = this.handleChangeCountry.bind(this);
    }

    // Handle fields change
    handleChangeInput = (input) => (e) => {
        this.setState({[input]: e.target.value});
    };

    handleChangeSelectAndAge = (input) => (value) => {
        console.log(`selected ${value} for ${input}`);
        this.setState({[input]: value});
    };

    componentDidMount() {
        fetch("http://localhost:8080/api/v1/user/registration/countries")
            .then((response) => {
                console.log(response);
                return response.json();
            })
            .then((data) => {
                let countriesFromApi = data.map((country) => {
                    return {value: country, display: country};
                });
                this.setState({
                    countries: [
                        {
                            value: "",
                            display: `(Select your country of residence)`,
                        },
                    ].concat(countriesFromApi),
                    cities: [
                        {
                            value: "",
                            display: "(Select your city of residence)"
                        }
                    ],
                });
            })
            .catch((error) => {
                console.log(error);
            });

        fetch("http://localhost:8080/api/v1/user/registration/languages")
            .then((response) => {
                console.log(response);
                return response.json();
            })
            .then((data) => {
                let languagesFromApi = data.map((language) => {
                    return {value: language, display: language};
                });
                this.setState({
                    languages: [
                        {
                            value: "",
                            display: `(Select your language)`
                        }
                    ].concat(languagesFromApi)
                });
            })
            .catch((error) => {
                console.log(error);
            });
    }

    handleChangeCountry = (value) => {
        console.log(`selected ${value}`);
        this.setState({
                country: value,
                cities: []
            }, () => {
                fetch(`http://localhost:8080/api/v1/user/registration/cities/${value}`)
                    .then((response) => {
                        console.log(response);
                        return response.json();
                    })
                    .then((data) => {
                        let citiesFromApi = data.map((city) => {
                            return {value: city, display: city};
                        });
                        this.setState({
                            cities: [
                                {
                                    value: "",
                                    display: `(Select your city of residence)`,
                                },
                            ].concat(citiesFromApi),
                        });
                    })
                    .catch((error) => {
                        console.log(error);
                    })
            }
        );
    };

    // Proceed to the next step
    nextStep = () => {
        const {step} = this.state;
        this.setState({
            step: step + 1,
        });
    };

    // Proceed to the prev step
    prevStep = () => {
        const {step} = this.state;
        this.setState({
            step: step - 1,
        });
    };

    // Proceed to failure screen
    goToStep5 = () => {
        // const {step} = this.state;
        this.setState({
            step: 5
        })
    }

    // Proceed to the first step
    goToStep1 = () => {
        // const {step} = this.state;
        this.setState({
            step: 1
        })
    }

    render() {
        const {step} = this.state;
        const {
            login,
            password,
            email,
            gender,
            selectedGender,
            age,
            countries,
            country,
            cities,
            city,
            province,
            languages,
            languageNative1,
            languageNative2,
            languageNative3,
            languageSpoken1,
            languageSpoken2,
            languageSpoken3,
            languageSpoken4,
            languageSpoken5,
            languageToLearn,
            selfDescription
        } = this.state;

        const values = {
            login,
            password,
            email,
            gender,
            selectedGender,
            age,
            countries,
            country,
            cities,
            city,
            province,
            languages,
            languageNative1,
            languageNative2,
            languageNative3,
            languageSpoken1,
            languageSpoken2,
            languageSpoken3,
            languageSpoken4,
            languageSpoken5,
            languageToLearn,
            selfDescription
        };

        switch (step) {
            case 1:
                return (
                    <Step1PersonalDetails
                        nextStep={this.nextStep}
                        handleChangeInput={this.handleChangeInput}
                        handleChangeSelectAndAge={this.handleChangeSelectAndAge}
                        handleChangeCountry={this.handleChangeCountry}
                        values={values}
                    />
                );
            case 2:
                return (
                    <Step2LingoDetails
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChangeSelectAndAge={this.handleChangeSelectAndAge}
                        handleChangeInput={this.handleChangeInput}
                        values={values}
                    />
                );
            case 3:
                return (
                    <Step3Confirmation
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        goToStep5={this.goToStep5}
                        values={values}
                    />
                );
            case 4:
                return <Step4Success/>

            case 5:
                return (
                    <Step5Failure goToStep1={this.goToStep1}/>
                );
        }
    }
}

export default UserForm;
