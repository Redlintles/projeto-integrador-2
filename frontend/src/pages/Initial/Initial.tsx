import styles from "./Initial.module.css";
import AsideLoggedIn from "../../../.history/src/components/AsideLoggedIn_20241114194110";

export default function Initial() {
  return (
    <section className={styles["initial"]}>
      <AsideLoggedIn fullName="João Paulo" />
      <h1>Hello WOrld!</h1>
    </section>
  );
}
