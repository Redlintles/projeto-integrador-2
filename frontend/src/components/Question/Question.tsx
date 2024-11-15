import styles from "./Question.module.css";

interface QuestionProps {
  alternatives: string[];
  question: string;
  number: number;
}

export default function Question({
  alternatives,
  question,
  number,
}: QuestionProps) {
  return (
    <div className={styles["question"]}>
      <h4 className={styles["question__title"]}>
        <span>{number}. </span>
        {question}
      </h4>
      <div className={styles["question-options"]}>
        {alternatives.map((item) => (
          <div className={styles["question-options__option"]}>
            <p>{item}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
