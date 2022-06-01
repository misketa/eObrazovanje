import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { LoginComponent } from './components/login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Studentska sluzba';

  constructor(private router: Router) {}


  tooglePrijavaTask(pageName: string): void{
    this.router.navigate([`${pageName}`]);

  }

}
