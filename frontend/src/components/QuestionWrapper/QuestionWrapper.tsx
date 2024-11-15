import Question from "../Question/Question";
import styles from "./QuestionWrapper.module.css";

interface QuestionInfo {
  title: string;
  answers: string[];
}

interface QuestionWrapperProps {
  section: [number, number];
  title: string;
  questions: QuestionInfo[];
}

export default function QuestionWrapper({
  section,
  title,
  questions,
}: QuestionWrapperProps) {
  return (
    <div className={styles["question-wrapper"]}>
      <div className={styles["question-wrapper__top"]}>
        <h3 className={styles["question-wrapper__title"]}>
          Seção {section[0]}: {title}
        </h3>
        <span className={styles["question-wrapper__progress"]}>
          Passo {section[0]} de {section[1]}
        </span>
      </div>

      <div className={styles["question-wrapper__wrapper"]}>
        {questions.map((item: QuestionInfo, i: number) => (
          <Question
            alternatives={item.answers}
            question={item.title}
            number={i + 1}
          />
        ))}
      </div>
    </div>
  );
}
