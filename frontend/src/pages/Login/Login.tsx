import AsideWelcome from "../../components/AsideWelcome/AsideWelcome";
import WelcomeFormInput from "../../components/WelcomeFormInput/WelcomeFormInput";
import { IoMdMail } from "react-icons/io";
import { FaLock } from "react-icons/fa6";
import { Link, useNavigate } from "react-router-dom";
import styles from "./Login.module.css";
import { FormEvent, useContext, useState } from "react";
import { userContext } from "../../contexts/UserContext";

export default function Login() {
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const navigate = useNavigate();

  const { setUser } = useContext(userContext);

  const [errorMsg, setErrorMsg] = useState<boolean>(false);

  function onSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();

    fetch("/api/user/login", {
      method: "POST",

      body: JSON.stringify({
        email,
        password,
      }),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        console.log(res);
        if (res.token) {
          setUser({
            token: res.token,
            user: res.user,
          });
          navigate("/initial");
        } else {
          setErrorMsg(true);
          setTimeout(() => setErrorMsg(false), 5000);
        }
      });
  }

  return (
    <section className={styles["login"]}>
      <AsideWelcome type="login" />
      <div className={styles["login__right"]}>
        <h2>Acesse sua Conta</h2>
        {errorMsg && <h2>Login Falhou</h2>}
        <form onSubmit={onSubmit} className={styles["login__form"]}>
          <WelcomeFormInput
            type="email"
            name="email"
            icon={<IoMdMail />}
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <WelcomeFormInput
            name="password"
            type="password"
            placeholder="Senha"
            icon={<FaLock />}
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
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
