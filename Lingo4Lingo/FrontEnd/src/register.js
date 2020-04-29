import React from "react";
import { UserForm } from './multiStepRegForm/UserForm';

function displayRegisterForm() {

  return (
    <div>
      <div className="register">
        <UserForm />
      </div>
    </div>
  );
}

export default displayRegisterForm;
