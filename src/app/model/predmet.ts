export class Predmet implements PredmetInterface {
  public predmet_id: number;
  public naziv: string;
  public semestar: string;
  public espb: string;
  public opis: string;

  constructor(predmetCfg: PredmetInterface) {
    this.predmet_id = predmetCfg.predmet_id;
    this.naziv = predmetCfg.naziv;
    this.semestar = predmetCfg.semestar;
    this.espb = predmetCfg.espb;
    this.opis = predmetCfg.opis;
  }
}

interface PredmetInterface {
  predmet_id: number;
  naziv: string;
  semestar: string;
  espb: string;
  opis: string;
}
