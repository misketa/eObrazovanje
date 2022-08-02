import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

import { Student } from '../../model/student.model';
import { StudentService } from '../student/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
})
export class StudentsComponent implements OnInit {
  students: Student[];

  subscription: Subscription;

  constructor(private studentService: StudentService, private router: Router) {
    this.subscription = studentService.RegenerateData$.subscribe(() =>
      this.getStudents()
    );
  }

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents() {
    this.studentService
      .getStudents()
      .subscribe((res) => (this.students = res.body));
  }

  gotoAdd(): void {
    this.router.navigate(['/addStudent']);
  }

  gotoEdit(student: Student): void {
    this.router.navigate(['/editStudent', student.student_id]);
  }

  deleteStudent(studentId: number): void {
    this.studentService
      .deleteStudent(studentId)
      .subscribe(() => this.getStudents());
  }
}
