import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthService } from '../app/services/auth/auth.service';
import { LoginRequest } from './model/LoginRequest';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Studentska sluzba';

  korisnickoIme: string | undefined;
  lozinka: string | undefined;
  korisnik: any;
  showErrorMessage: any;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    console.log('Thats all folks!');
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
      this.showErrorMessage = false;
      console.log('TEST: ' + JSON.stringify(value));
      if (value != null) {
        localStorage.setItem('korisnik', JSON.stringify(value));
        this.router.navigate(['home']);
      } else {
        this.showErrorMessage = true;
      }
    });
    this.korisnickoIme = '';
    this.lozinka = '';
  }
}
