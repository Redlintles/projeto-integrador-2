import AsideWelcome from "../../components/AsideWelcome/AsideWelcome";
import WelcomeFormInput from "../../components/WelcomeFormInput/WelcomeFormInput";
import { IoMdMail } from "react-icons/io";
import { FaLock } from "react-icons/fa6";
import { Link } from "react-router-dom";
import styles from "./Login.module.css";

export default function Login() {
  return (
    <section className={styles["login"]}>
      <AsideWelcome type="login" />
      <div className={styles["login__right"]}>
        <h2>Acesse sua Conta</h2>
        <form action="" className={styles["login__form"]}>
          <WelcomeFormInput
            type="email"
            name="email"
            icon={<IoMdMail />}
            placeholder="Email"
          />
          <WelcomeFormInput
            name="password"
            type="password"
            placeholder="Senha"
            icon={<FaLock />}
          />
          <p className={styles["login-form__text"]}>
            Não tem uma conta? <Link to="/register">Cadastre-se</Link>
          </p>
          <button
            className={`btn btn--lg btn--dark ${styles["welcome-form__submit-btn"]}`}
          >
            Acessar
          </button>
        </form>
      </div>
    </section>
  );
}
