import { Korisnik } from './korisnik.model';

export interface Student{
    godinaStudija: string,
    godinaUpisa: string,
    statusStudenta: string,
    budzet: boolean,
    istorijaStudiranja: FileList,
    smer: string,
    dokumenti: string,
    kartica: string,
    korisnik: any
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
    ){}

}