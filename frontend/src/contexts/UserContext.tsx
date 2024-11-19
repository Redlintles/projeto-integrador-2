import { createContext, ReactNode, useState } from "react";

interface ImpactPanel {
  id: number;
  impactoIndividual: string;
  impactoColetivo: string;
}

interface User {
  id: number;
  cpf: string;
  nome: string;
  email: string;
  senha: string;
  habitosDiarios: number;
  pegadaCarbono: number;
  medalhas: number;
  endereco: string;
  idPainelDeImpacto: ImpactPanel;
}

interface UserContext {
  user: User | null;
  token: string | null;
}

interface UserContextState {
  user: UserContext;
  setUser: React.Dispatch<React.SetStateAction<UserContext>>;
}

// eslint-disable-next-line react-refresh/only-export-components
export const userContext = createContext<UserContextState>({
  user: { user: null, token: null },
  setUser: () => {},
});

export const UserContextProvider = ({ children }: { children: ReactNode }) => {
  const [user, setUser] = useState<UserContext>({
    user: null,
    token: null,
  });

  return (
    <userContext.Provider value={{ user, setUser }}>
      {children}
    </userContext.Provider>
  );
};
