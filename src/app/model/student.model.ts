export class Student {
  student_id: number;
  korisnickoIme: string;
  lozinka: string;
  ime: string;
  prezime: string;
  jmbg: string;
  telefon: string;
  godinaStudija: string;
  godinaUpisa: string;
  statusStudenta: string;
  budzet: string;
  smer: string;

  /*constructor(studentCfg: StudentInterface) {
    this.id = studentCfg.id || 0;
    this.korisnickoIme = studentCfg.korisnickoIme || '';
    this.ime = studentCfg.ime || '';
    this.pcrezime = studentCfg.prezime || '';
    this.jmbg = studentCfg.jmbg || '';
    this.telefon = studentCfg.telefon || '';
    this.godinaStudija = studentCfg.godinaStudija || '';
    this.godinaUpisa = studentCfg.godinaUpisa || '';
    this.statusStudenta = studentCfg.statusStudenta || '';
    this.budzet = studentCfg.budzet || '';
    this.smer = studentCfg.smer || '';
  }*/
}

/*interface StudentInterface {
  id: number;
  korisnickoIme: string;
  ime: string;
  prezime: string;
  smer: string;
  budzet: string;
  statusStudenta: string;
  godinaUpisa: string;
  godinaStudija: string;
  telefon: string;
  jmbg: string;
}

/*import { Korisnik } from './korisnik.model';

export interface Student {
  godinaStudija: string;
  godinaUpisa: string;
  statusStudenta: string;
  budzet: boolean;
  istorijaStudiranja: FileList;
  smer: string;
  dokumenti: string;
  kartica: string;
  korisnik: any;
}

export class Student {
  constructor(
    godinaStudija: string,
    godinaUpisa: string,
    statusStudenta: string,
    budzet: boolean,
    istorijaStudiranja: FileList,
    smer: string,
    dokumenti: string,
    kartica: string,
    korisnik: Korisnik
  ) {}
}*/
