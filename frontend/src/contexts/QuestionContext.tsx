import { createContext, ReactNode, useState } from "react";

interface QuestionContext {
  answers: Array<[number, string]>;
  currentScore: number;
}

interface QuestionContextState {
  state: QuestionContext;
  setState: React.Dispatch<React.SetStateAction<QuestionContext>>;
}

// eslint-disable-next-line react-refresh/only-export-components
export const questionContext = createContext<QuestionContextState | null>(null);

export const QuestionContextProvider = ({
  children,
}: {
  children: ReactNode;
}) => {
  const [state, setState] = useState<QuestionContext>({
    answers: [],
    currentScore: 0,
  });

  return (
    <questionContext.Provider value={{ state, setState }}>
      {children}
    </questionContext.Provider>
  );
};
