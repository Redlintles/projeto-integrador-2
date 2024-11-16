import React, { ReactNode } from "react";

import styles from "./WelcomeFormInput.module.css";
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
    <label className={styles["welcome-form-input"]}>
      <span className={styles["welcome-form-input__icon"]}>{icon}</span>
      <input
        type={type}
        placeholder={placeholder}
        name={name}
        className={styles["welcome-form-input__input"]}
      />
    </label>
  );
}
