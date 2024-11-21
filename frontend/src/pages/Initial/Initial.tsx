import { Link, useNavigate } from "react-router-dom";
import AsideLoggedIn from "../../components/AsideLoggedIn/AsideLoggedIn";
import styles from "./Initial.module.css";
import home1 from "../../assets/home-1.png";
import home2 from "../../assets/home-2.png";
import home3 from "../../assets/home-3.png";
import { useContext } from "react";
import { userContext } from "../../contexts/UserContext";

export default function Initial() {
  const { user } = useContext(userContext);
  const navigate = useNavigate();

  if (!user.user) {
    navigate("/");
  }
  return (
    <section className={styles["initial"]}>
      <AsideLoggedIn fullName={user.user?.nome || ""} />
      <div className={styles["initial-main"]}>
        <div
          className={`${styles["initial-main__info"]} ${styles["initial-main__info--suggestion"]}`}
        >
          <Link
            to="/suggestion"
            className={styles["initial-main__link"]}
          ></Link>
          <h4 className={styles["initial-main__title"]}>
            Sugestões de Ações Diárias
          </h4>
          <div>
            <div className={styles["initial-main__text"]}>
              <p>
                Diariamente acompanhe as sugestões de novos hábitos a serem
                inseridos em sua rotina!
              </p>
              <p>
                As sugestões visam vantagens para o meio ambiente e você mesmo,
                a cada ação feita, você receberá 10 pontos que irão de ajudar a
                crescer no ranking semanal e a conquistar medalhas
              </p>
            </div>
            <img src={home1} alt="" className={styles["initial-main__img"]} />
          </div>
        </div>
        <div
          className={`${styles["initial-main__info"]} ${styles["initial-main__info--ranking"]}`}
        >
          <Link to="/ranking" className={styles["initial-main__link"]}></Link>
          <h4>Ranking Semanal</h4>
          <div className={styles["initial-main__text"]}>
            <p>
              Semanalmente acompanhe o seu progresso e o compare com o de outros
              usuários, garantindo pontos extras se ficar em primeiro lugar
            </p>
          </div>
          <img src={home2} alt="" className={styles["initial-main__img"]} />
        </div>
        <div
          className={`${styles["initial-main__info"]} ${styles["initial-main__info--medals"]}`}
        >
          <Link to="/medals" className={styles["initial-main__link"]}></Link>
          <h4>Medalhas</h4>
          <div className={styles["initial-main__text"]}>
            <p>
              Ao arrecadar pontos e avançar no ranking semanal, garanta medalhas
              exclusivas.
            </p>
            <p>Cada medalha ganha, vem acompanhada de uma recompensa</p>
          </div>
          <img src={home3} alt="" className={styles["initial-main__img"]} />
        </div>
      </div>
    </section>
  );
}
