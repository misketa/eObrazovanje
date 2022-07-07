import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs';
import { FinansijskaKartica } from '../_model/finansijskaKartica.model';

@Injectable({
  providedIn: 'root'
})
export class KarticaService {

  private Url = 'api/kartice';
  constructor(private http: HttpClient) { }

  Uplati(iznos:number){
    console.log("test")
    return this.http.post(`http://localhost:8080/${this.Url}/uplate`,{
      "iznos":iznos
    })
  }
  getKartica(){
    return this.http.get<FinansijskaKartica>(`http://localhost:8080/${this.Url}`)
  }
}


