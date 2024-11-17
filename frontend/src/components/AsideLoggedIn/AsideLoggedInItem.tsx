import { ReactNode } from "react";
import { Link } from "react-router-dom";
import styles from "./AsideLoggedIn.module.css";
interface AsideLoggedInItemProps {
  to: string;
  icon: ReactNode;
  text: string;
}

export default function AsideLoggedInItem({
  to,
  icon,
  text,
}: AsideLoggedInItemProps) {
  return (
    <Link to={to} className={styles["logged-in__item"]}>
      <span>{icon}</span>
      <p>{text}</p>
    </Link>
  );
}
