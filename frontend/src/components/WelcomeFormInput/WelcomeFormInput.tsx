import React, { ReactNode } from "react";

import styles from "./WelcomeFormInput.module.css";
interface WelcomeFormInputProps
  extends React.InputHTMLAttributes<HTMLInputElement> {
  icon: ReactNode;
}

export default function WelcomeFormInput({
  type,
  icon,
  placeholder,
  value,
  onChange,
  name,
}: WelcomeFormInputProps) {
  return (
    <label className={styles["welcome-form-input"]}>
      <span className={styles["welcome-form-input__icon"]}>{icon}</span>
      <input
        type={type}
        placeholder={placeholder}
        name={name}
        value={value}
        onChange={onChange}
        className={styles["welcome-form-input__input"]}
      />
    </label>
  );
}
