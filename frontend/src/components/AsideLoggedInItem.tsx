import { ReactNode } from "react";
import { Link } from "react-router-dom";

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
    <Link to={to} className="logged-in__item">
      {icon}
      <p>{text}</p>
    </Link>
  );
}
