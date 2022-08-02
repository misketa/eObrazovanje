export class Korisnik implements KorisnikInterface {
  public id: number;
  public korisnickoIme: string;
  public lozinka: string;
  public ime: string;
  public prezime: string;
  public jmbg: string;
  public telefon: string;

  constructor(korisnikCfg: KorisnikInterface) {
    this.id = korisnikCfg.id;
    this.korisnickoIme = korisnikCfg.korisnickoIme;
    this.lozinka = korisnikCfg.lozinka;
    this.ime = korisnikCfg.ime;
    this.prezime = korisnikCfg.prezime;
    this.jmbg = korisnikCfg.jmbg;
    this.telefon = korisnikCfg.telefon;
  }
}

interface KorisnikInterface {
  id: number;
  korisnickoIme: string;
  lozinka: string;
  ime: string;
  prezime: string;
  jmbg: string;
  telefon: string;
}

declare global {
  namespace Express {
    interface KorisnikInterface {
      id: number;
      korisnickoIme: string;
      lozinka: string;
      ime: string;
      prezime: string;
      jmbg: string;
      telefon: string;
    }
  }
}
