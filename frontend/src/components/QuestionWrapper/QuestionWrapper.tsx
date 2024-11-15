import React from "react";
import Question from "../Question/Question";

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
    <div>
      <div>
        <h3>
          Seção {section[0]}: {title}
        </h3>
        <span>
          Passo {section[0]} de {section[1]}
        </span>
      </div>

      <div>
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
