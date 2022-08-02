import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Student } from './../../../model/student.model';
import { StudentService } from './../../../components/student/student.service';
import { UserService } from './../../../services/user/user.service';
import { Korisnik } from './../../../model/korisnik.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  user: any;

  korisnickoIme: string;

  student: any;

  korisnik: Korisnik;

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.user = this.authService.getToken();
    this.korisnickoIme = this.korisnik.korisnickoIme;
    if (this.user.roles == 'PREDAVAC' || this.user.roles == 'ADMIN') {
      this.userService
        .getUserByUsername(this.korisnickoIme)
        .subscribe((user) => (this.korisnik = user));
    }
    if (this.user.roles == 'STUDENT') {
      this.student = new Student();
      this.studentService
        .getStudentByUsername(this.korisnickoIme)
        .subscribe((student) => (this.student = student));
    }
  }
}
