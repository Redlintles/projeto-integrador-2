import styles from "./Suggestion.module.css";
import AsideLoggedIn from "../../components/AsideLoggedIn/AsideLoggedIn";

export default function Suggestion() {
  const score: number = 0;

  const suggestions = [
    {
      title: "Não use lâmpadas durante o dia!",
      description:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit soluta placeat itaque, libero inventore harum architecto nam? Amet libero vero omnis dolore autem quae dicta ut, repellendus tempora facilis aliquid!",
      impact: 0.8,
    },
    {
      title: "Não use lâmpadas durante o dia!",
      description:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit soluta placeat itaque, libero inventore harum architecto nam? Amet libero vero omnis dolore autem quae dicta ut, repellendus tempora facilis aliquid!",
      impact: 0.8,
    },
    {
      title: "Não use lâmpadas durante o dia!",
      description:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit soluta placeat itaque, libero inventore harum architecto nam? Amet libero vero omnis dolore autem quae dicta ut, repellendus tempora facilis aliquid!",
      impact: 0.8,
    },
  ];
  return (
    <section className={styles["suggestion"]}>
      <AsideLoggedIn fullName="João Paulo" />
      <div className={styles["suggestion-main"]}>
        <div className={styles["suggestion-main__header"]}>
          <h4>Sugestões de Ações Diárias</h4>
          <p>Pontuação Atual: {score} pontos</p>
        </div>
        <div className={styles["suggestion-main__content"]}>
          {suggestions &&
            suggestions.map((item) => (
              <div className={styles["suggestion-item"]}>
                <h5 className={styles["suggestion-item__title"]}>
                  {item.title}
                </h5>
                <p className={styles["suggestion-item__desc"]}>
                  {item.description}
                </p>
                <div className={styles["suggestion-item__footer"]}>
                  <p>Impacto: -{item.impact} Kg de CO²</p>
                  <div>
                    <button
                      className={`btn btn--sm btn--dark ${styles["suggestion-item__btn"]}`}
                    >
                      Eu fiz isso!
                    </button>
                    <button
                      className={`btn btn--sm btn--red ${styles["suggestion-item__btn"]}`}
                    >
                      Tentarei mais tarde!
                    </button>
                  </div>
                </div>
              </div>
            ))}
        </div>
      </div>
    </section>
  );
}
