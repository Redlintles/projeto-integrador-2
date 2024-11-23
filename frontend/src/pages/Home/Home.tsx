import styles from "./Home.module.css";
import greenActionLogo from "../../assets/greenactionlogo.png";
import { Link, useNavigate } from "react-router-dom";
import homeReason1 from "../../assets/paginainicial-1.png";
import homeReason2 from "../../assets/paginainicial-2.png";

import webDevImg from "../../assets/Web Development.png";
import chartImg from "../../assets/Bar Chart.png";
import prizeImg from "../../assets/Prize.png";
import { useContext, useEffect } from "react";
import { userContext } from "../../contexts/UserContext";
import { ApiResponse } from "../../types/ApiResponse";

export default function Home() {
  const { user, setUser } = useContext(userContext);
  const navigate = useNavigate();

  useEffect(() => {
    const url: string = `/api/token/validByToken/${user.token}`;
    fetch(url)
      .then((res) => res.json())
      .then((data: ApiResponse) => {
        console.log(url);
        console.log(data);
        if (data.data) {
          navigate("/initial");
        } else {
          setUser({ user: null, token: null });
        }
      });
  }, []);

  console.log(user);
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
      <div className={styles["home-reason"]}>
        <img src={homeReason1} alt="" className={styles["home-reason__img"]} />
        <div className={styles["home-reason__text"]}>
          <h2>Luta contra mudanças climáticas.</h2>
          <p>
            Com o agravamento dos fenômenos naturais, adotar hábitos
            sustentáveis não é mais uma escolha - é uma necessidade para lutar
            contra as mudanças climáticas.
          </p>
        </div>
      </div>
      <div className={styles["home-reason"]}>
        <img src={homeReason2} alt="" className={styles["home-reason__img"]} />
        <div className={styles["home-reason__text"]}>
          <h2>Transformar de forma simples.</h2>
          <p>
            Através do Green Action, você pode fazer parte dessa transformação,
            implementando ações simples que fazem a diferença para o planeta
          </p>
        </div>
      </div>
      <div className={styles["home-feature"]}>
        <img src={webDevImg} alt="" className={styles["home-feature__img"]} />
        <div className={styles["home-feature__text"]}>
          <h2>Sugestões Personalizadas:</h2>
          <p>Receba dicas práticas para reduzir o seu impacto ambiental.</p>
        </div>
      </div>
      <div className={styles["home-feature"]}>
        <img src={chartImg} alt="" className={styles["home-feature__img"]} />
        <div className={styles["home-feature__text"]}>
          <h2>Impacto Coletivo:</h2>
          <p>Veja o efeito da sua contribuição em tempo real.</p>
        </div>
      </div>
      <div className={styles["home-feature"]}>
        <img src={prizeImg} alt="" className={styles["home-feature__img"]} />
        <div className={styles["home-feature__text"]}>
          <h2>Desafios Semanais:</h2>
          <p>Partice de desafios semanais e suba no ranking.</p>
        </div>
      </div>
    </section>
  );
}
