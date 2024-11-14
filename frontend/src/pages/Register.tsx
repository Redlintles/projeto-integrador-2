import { Link } from "react-router-dom";
import AsideWelcome from "../components/AsideWelcome";
import { FaLock, FaUser } from "react-icons/fa";
import { IoMdMail } from "react-icons/io";

export default function Register() {
  return (
    <section className="register">
      <AsideWelcome type="register" />
      <div className="register__right">
        <h2>Crie sua conta</h2>
        <form action="">
          <label className="welcome__label">
            <FaUser />
            <input type="text" name="" className="welcome__input" />
          </label>
          <label className="welcome__label">
            <IoMdMail />
            <input type="text" name="" className="welcome__input" />
          </label>
          <label className="welcome__label">
            <FaLock />
            <input type="password" name="" className="welcome__input" />
          </label>
          <label className="welcome__label">
            <FaLock />
            <input type="password" name="" className="welcome__input" />
          </label>
          <p>
            Já tem uma conta? <Link to="/login">Faça Login</Link>
          </p>
          <button type="submit" className="welcome__submit">
            Cadastrar
          </button>
        </form>
      </div>
    </section>
  );
}
