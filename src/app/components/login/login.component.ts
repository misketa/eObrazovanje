import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/model/LoginRequest';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  korisnickoIme: string | undefined;
  lozinka: string | undefined;
  korisnik: any;
  showErrorMessage: any;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    if (!this.korisnickoIme) {
      alert('Please enter a korisnicko Ime!');
      return;
    } else if (!this.lozinka) {
      alert('Please enter a lozinka!');
      return;
    }

    const object: LoginRequest = {
      korisnickoIme: this.korisnickoIme,
      lozinka: this.lozinka,
    };

    this.authService.login(object).subscribe((value) => {
      console.log(value);
      this.showErrorMessage = false;
      console.log('TEST: ' + JSON.stringify(value));
      if (value != null) {
        localStorage.setItem('token', JSON.stringify(value));
        this.router.navigate(['']);
      } else {
        this.showErrorMessage = true;
      }
    });
    this.korisnickoIme = '';
    this.lozinka = '';
  }
}
