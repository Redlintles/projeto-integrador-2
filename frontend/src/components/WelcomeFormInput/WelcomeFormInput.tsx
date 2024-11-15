import React, { ReactNode } from "react";

interface WelcomeFormInputProps {
  type: string;
  icon: ReactNode;
  placeholder: string;
  name: string;
}

export default function WelcomeFormInput({
  type,
  icon,
  placeholder,
  name,
}: WelcomeFormInputProps) {
  return (
    <label className="welcome-form-input">
      {icon}
      <input
        type={type}
        placeholder={placeholder}
        name={name}
        className="welcome-form-input__input"
      />
    </label>
  );
}
