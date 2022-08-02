import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of, Subject, tap } from 'rxjs';

export interface Predmet {
  id: number;
}

@Injectable({
  providedIn: 'root',
})
export class PredavacService {
  private predavaciUrl = 'api/predavaci';

  constructor(private http: HttpClient) {}

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
    this.RegenerateData.next();
  }
  getPredmeti(id: number) {
    const url = `${this.predavaciUrl}/${id}/predmeti`;
    // return this.http.get<Predmet[]>(url)
    const predmenti: Predmet[] = [{ id: 1 }, { id: 2 }, { id: 3 }];
    return of(predmenti);
  }
}
