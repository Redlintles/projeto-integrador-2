import AsideLoggedInItem from "./AsideLoggedInItem";
import { FaHouse } from "react-icons/fa6";
import { PiMedal } from "react-icons/pi";
import { HiMiniViewColumns } from "react-icons/hi2";
import { RxExit } from "react-icons/rx";
import styles from "./AsideLoggedIn.module.css";
interface AsideLoggedInProps {
  fullName: string;
}

export default function AsideLoggedIn({ fullName }: AsideLoggedInProps) {
  const nomeIniciais: string = fullName
    .split(" ")
    .map((item: string) => item[0])
    .join("")
    .toUpperCase();
  return (
    <aside className={styles["logged-in"]}>
      <div>
        <div className={styles["logged-in__profile"]}>
          <h3>{nomeIniciais}</h3>
        </div>
        <div className={styles["logged-in__container"]}>
          <AsideLoggedInItem
            icon={<FaHouse />}
            to="/initial"
            text="Página Inicial"
          />
          <AsideLoggedInItem
            icon={<PiMedal />}
            to="/suggestion"
            text="Sugestões"
          />
          <AsideLoggedInItem
            icon={<HiMiniViewColumns />}
            to="/ranking"
            text="Ranking"
          />
          <AsideLoggedInItem
            icon={<HiMiniViewColumns />}
            to="/medals"
            text="Medalhas"
          />
        </div>
      </div>
      <AsideLoggedInItem icon={<RxExit />} to="/" text="Sair" />
    </aside>
  );
}
