import styles from "./Home.module.css";
export default function Home() {
  return (
    <section className={styles["home"]}>
      <div className={styles["home-logo"]}>
        <img src="" alt="" className={styles["home-logo__img"]} />
        <h1 className={styles["home-logo__title"]}>Green Action</h1>
        <p className={styles["home-logo__text"]}>
          Engajando ações, conscientizando o futuro
        </p>
      </div>
      <div className={styles["home-actions"]}>
        <p className={styles["home-actions__text"]}>
          Reduza sua pegada de carbono e faça parte da mudança para um futuro
          sustentável
        </p>
        <button
          className={`${styles["home-actions__btn"]} ${styles["home-actions__btn--register"]}`}
        >
          Comece Agora
        </button>
        <button
          className={`${styles["home-actions__btn"]} ${styles["home-actions__btn--login"]}`}
        >
          Já tenho uma conta
        </button>
      </div>
      <p className={styles["home__text"]}>
        Receba sugestões personalizadas de acordo com o seu estilo de vida!
      </p>
    </section>
  );
}
