import React from "react";
import { FaArrowLeft } from "react-icons/fa6";
import { Link } from "react-router-dom";
import styles from "./AsideWelcome.module.css";
interface AsideWelcomeProps {
  type: "register" | "login";
}

export default function AsideWelcome({ type }: AsideWelcomeProps) {
  let titleText: string = "";
  let textContent: string = "";
  if (type === "register") {
    titleText = "Bem Vindo";
    textContent =
      "Comece hoje a fazer a diferença, siga sugestões sustentáveis";
  } else if (type === "login") {
    titleText = "Bem Vindo de Volta";
    textContent = "Continue fazendo a diferença, acesse sua conta!";
  }

  return (
    <section className={styles["aside-welcome"]}>
      <Link to="/" className={styles["aside-welcome__goback"]}>
        <FaArrowLeft />
      </Link>
      <h2 className={styles["aside-welcome__title"]}>{titleText}</h2>
      <p className={styles["aside-welcome__text"]}>{textContent}</p>
      <img src="" alt="" className={styles["aside-welcome__img"]} />
    </section>
  );
}
