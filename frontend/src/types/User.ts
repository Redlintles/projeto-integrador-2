import { ImpactPanel } from "./ImpactPanel";
export interface User {
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
