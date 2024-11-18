import styles from "./Ranking.module.css";
import AsideLoggedIn from "../../components/AsideLoggedIn/AsideLoggedIn";
export default function Ranking() {
  const colorList = [
    "#74B474",
    "#7E97A4",
    "#F8C531",
    "#5D3664",
    "#B81617",
    "#743014",
  ];

  function getColorIndex(index: number) {
    let colorIndex = 0;

    if (index < colorList.length) {
      colorIndex = index;
    }

    if (index >= colorList.length) {
      colorIndex = Math.floor(index % colorList.length);
    }

    console.log("Indice:", index, colorIndex, colorList.length);

    return colorIndex;
  }
  const rankingData = [
    {
      fullName: "João Paulo",
      score: 40,
    },
    {
      fullName: "João Paulo",
      score: 30,
    },
    {
      fullName: "João Paulo",
      score: 20,
    },
    {
      fullName: "João Paulo",
      score: 10,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
    {
      fullName: "João Paulo",
      score: 0,
    },
  ];
  return (
    <section className={styles["ranking"]}>
      <AsideLoggedIn fullName="João Paulo" />

      <div className={styles["ranking-main"]}>
        <div className={styles["ranking-main__header"]}>
          <h4 className={styles["ranking-main__title"]}>Ranking</h4>
          <p className={styles["ranking-main__text"]}>
            Os pontos indicam o quanto você progrediu!
          </p>
          <p className={styles["ranking-main__text"]}>
            Você pode comparar os seus resultados com os de outros usuários
          </p>
        </div>
        <div className={styles["ranking-main__content"]}>
          {rankingData &&
            rankingData.map((item, i) => (
              <div className={styles["ranking-item"]}>
                <div>
                  <div
                    className={styles["ranking-item__profile"]}
                    style={{ backgroundColor: colorList[getColorIndex(i)] }}
                  >
                    <span>
                      {item.fullName
                        .split(" ")
                        .map((word) => word[0])
                        .join("")
                        .toUpperCase()}
                    </span>
                  </div>
                  <h5 className={styles["ranking-item__title"]}>
                    {item.fullName}
                  </h5>
                </div>
                <p className={styles["ranking-item__score"]}>
                  {item.score} Pontos
                </p>
              </div>
            ))}
        </div>
      </div>
    </section>
  );
}
