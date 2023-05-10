import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginRequest } from './../../model/LoginRequest';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = `${environment.apiURL}/api/auth/login`;

  constructor(private http: HttpClient, public jwtHelper: JwtHelperService) {
    providers: [
      { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
      JwtHelperService,
    ];
  }

  login(request: LoginRequest): Observable<LoginRequest> {
    const response = this.http.post<LoginRequest>(
      this.apiUrl,
      request,
      httpOptions
    );

    console.log(response);
    return response;
  }

  getToken() {
    let token = JSON.parse(localStorage.getItem('token') || '{}');
    console.log(token);
    return token;
  }

  logout() {
    localStorage.removeItem('token');
  }

  public isAuthenticated(): boolean {
    const { token } = JSON.parse(localStorage.getItem('token') || '{}');
    return !this.jwtHelper.isTokenExpired(token);
  }
}
