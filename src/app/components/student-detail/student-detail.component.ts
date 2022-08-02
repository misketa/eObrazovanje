import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { StudentService } from '../student/student.service';
import { Student } from '../../model/student.model';

import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css'],
})
export class StudentDetailComponent implements OnInit {
  student: Student;

  mode: string;

  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute,
    private location: Location
  ) {
    this.student = new Student(/*{
      id: 0,
      korisnickoIme: '',
      ime: '',
      prezime: '',
      smer: '',
      budzet: '',
      statusStudenta: '',
      godinaUpisa: '',
      godinaStudija: '',
      telefon: '',
      jmbg: '',
    }*/);

    this.mode = 'ADD';
  }

  ngOnInit() {
    if (this.route.snapshot.params['id']) {
      this.mode = 'EDIT';
      // fetch student if we edit the existing student
      this.route.params
        .pipe(
          switchMap((params: Params) =>
            this.studentService.getStudent(+params['id'])
          )
        ) // convert to number
        .subscribe((res) => {
          this.student = res.body;
          this.studentService;
        });
    }
  }

  save(): void {
    this.mode == 'ADD' ? this.add() : this.edit();
  }

  private add(): void {
    this.studentService.addStudent(this.student).subscribe((res) => {
      this.studentService.announceChange();
      this.goBack();
    });
  }

  private edit(): void {
    this.studentService.editStudent(this.student).subscribe((student) => {
      this.studentService.announceChange();
      this.goBack();
    });
  }

  goBack(): void {
    this.location.back();
  }
}
