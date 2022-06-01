import { Korisnik } from './korisnik.model';

export interface Predavac{
    plata: number,
    korisnik: any
}

export class Predavac {
    
    constructor(
    plata: number,
    korisnik: Korisnik
    ){}

}