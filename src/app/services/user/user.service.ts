import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Korisnik } from './../../model/korisnik.model';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

const headers2 = {
  headers: new HttpHeaders({
    method: 'PUT',
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUsersUrl = `${environment.apiURL}/api/users`;

  constructor(private http: HttpClient) {}

  getUsers(): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>(this.apiUsersUrl);
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(`${this.apiUsersUrl}/${id}`);
  }
  getUserByUsername(username: string): Observable<any> {
    return this.http.get(`${this.apiUsersUrl}/username/${username}`);
  }

  updateUser(id: number, user: Korisnik): Observable<Korisnik> {
    return this.http.put<Korisnik>(
      `${this.apiUsersUrl}/${id}`,
      JSON.stringify(user),
      headers2
    );
  }
}
