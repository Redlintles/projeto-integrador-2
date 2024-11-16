import { Link } from "react-router-dom";
import AsideWelcome from "../../components/AsideWelcome/AsideWelcome";
import { FaLock, FaUser } from "react-icons/fa";
import { IoMdMail } from "react-icons/io";
import WelcomeFormInput from "../../components/WelcomeFormInput/WelcomeFormInput";
import styles from "./Register.module.css";

export default function Register() {
  return (
    <section className={styles["register"]}>
      <AsideWelcome type="register" />
      <div className={styles["register__right"]}>
        <h2>Crie sua conta</h2>
        <form action="" className={styles["welcome-form"]}>
          <WelcomeFormInput
            icon={<FaUser />}
            placeholder="Nome Completo"
            type="text"
            name="name"
          />
          <WelcomeFormInput
            icon={<IoMdMail />}
            placeholder="Email"
            type="email"
            name="email"
          />
          <WelcomeFormInput
            icon={<FaLock />}
            placeholder="Senha"
            type="password"
            name="password"
          />
          <WelcomeFormInput
            icon={<FaLock />}
            placeholder="Confirme a Senha"
            type="password"
            name="confirm_password"
          />
          <p className={styles["welcome-form__text"]}>
            Já tem uma conta? <Link to="/login">Faça Login</Link>
          </p>
          <button
            type="submit"
            className={`btn btn--lg btn--dark ${styles["welcome-form__submit-btn"]}`}
          >
            Cadastrar
          </button>
        </form>
      </div>
    </section>
  );
}
