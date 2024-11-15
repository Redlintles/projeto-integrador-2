import { Link } from "react-router-dom";
import AsideWelcome from "../../components/AsideWelcome/AsideWelcome";
import { FaLock, FaUser } from "react-icons/fa";
import { IoMdMail } from "react-icons/io";
import WelcomeFormInput from "../../components/WelcomeFormInput/WelcomeFormInput";

export default function Register() {
  return (
    <section className="register">
      <AsideWelcome type="register" />
      <div className="register__right">
        <h2>Crie sua conta</h2>
        <form action="">
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
          <p>
            Já tem uma conta? <Link to="/login">Faça Login</Link>
          </p>
          <button type="submit" className="btn btn-sm welcome__submit-btn">
            Cadastrar
          </button>
        </form>
      </div>
    </section>
  );
}
