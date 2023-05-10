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

  constructor() {}

  ngOnInit(): void {}
}
