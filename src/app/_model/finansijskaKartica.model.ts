import { Uplata } from "./uplata.model";

export interface FinansijskaKartica{
    kartica_id: number,
    stanje: number,
    uplate: Uplata[]
  }