import AsideWelcome from "../components/AsideWelcome";
import WelcomeFormInput from "../components/WelcomeFormInput";
import { IoMdMail } from "react-icons/io";
import { FaLock } from "react-icons/fa6";
import { Link } from "react-router-dom";

export default function Login() {
  return (
    <section className="login">
      <AsideWelcome type="login" />
      <div className="login__right">
        <h2>Acesse sua Conta</h2>
        <form action="" className="login__form">
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
          <p>
            Não tem uma conta? <Link to="/register">Cadastre-se</Link>
          </p>
          <button className="btn btn--sm welcome__submit-btn">Acessar</button>
        </form>
      </div>
    </section>
  );
}
