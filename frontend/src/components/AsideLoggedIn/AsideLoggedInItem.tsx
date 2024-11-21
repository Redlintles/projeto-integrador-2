import { ReactNode } from "react";
import { Link } from "react-router-dom";
import styles from "./AsideLoggedIn.module.css";
interface AsideLoggedInItemProps {
  to: string;
  icon: ReactNode;
  text: string;
  onClick?: (e: React.MouseEvent<HTMLAnchorElement, MouseEvent>) => void;
}

export default function AsideLoggedInItem({
  to,
  icon,
  text,
  onClick,
}: AsideLoggedInItemProps) {
  return (
    <Link
      to={to}
      className={styles["logged-in__item"]}
      onClick={onClick ? onClick : () => {}}
    >
      <span>{icon}</span>
      <p>{text}</p>
    </Link>
  );
}
