import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth.service';
import decode from 'jwt-decode';

@Injectable({
  providedIn: 'root',
})
export class GuardService implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    let expectedRole = route.data.expectedRole;
    const { token } = JSON.parse(localStorage.getItem('korisnik') || '{}');

    const tokenPayload: any = decode(token);

    if (
      !this.auth.isAuthenticated() ||
      !expectedRole.includes(tokenPayload.role.authority)
    ) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
