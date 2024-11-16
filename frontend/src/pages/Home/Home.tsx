import styles from "./Home.module.css";
import greenActionLogo from "../../assets/greenactionlogo.png";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <section className={styles["home"]}>
      <div className={styles["home-logo"]}>
        <img
          src={greenActionLogo}
          alt=""
          className={styles["home-logo__img"]}
        />
        <p className={styles["home-logo__text"]}>
          Engajando ações, conscientizando o futuro
        </p>
      </div>
      <div className={styles["home-actions"]}>
        <p className={styles["home-actions__text"]}>
          Reduza sua pegada de carbono e faça parte da mudança para um futuro
          sustentável
        </p>
        <Link
          to="/register"
          className={`btn btn--lg btn--upper btn--light ${styles["home-actions__btn"]} ${styles["home-actions__btn--register"]}`}
        >
          Comece Agora
        </Link>
        <Link
          to="/login"
          className={`btn btn--lg btn--upper btn--dark ${styles["home-actions__btn"]} ${styles["home-actions__btn--login"]}`}
        >
          Já tenho uma conta
        </Link>
      </div>
      <p className={styles["home__text"]}>
        Receba sugestões personalizadas de acordo com o seu estilo de vida!
      </p>
    </section>
  );
}
