import { Injectable } from '@angular/core';

import { HttpResponse, HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

import { Student } from '../../model/student.model';
import { environment } from 'src/environments/environment';

@Injectable()
export class StudentService {
  private studentsUrl = `${environment.apiURL}/api/studenti`;

  constructor(private http: HttpClient) {}

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
    this.RegenerateData.next();
  }

  getStudents(): Observable<HttpResponse<Student[]>> {
    return this.http.get<Student[]>(this.studentsUrl, { observe: 'response' });
  }

  getStudent(id: number): Observable<HttpResponse<Student>> {
    const url = `${this.studentsUrl}/${id}`;
    return this.http.get<Student>(url, { observe: 'response' });
  }

  addStudent(student: Student): Observable<HttpResponse<Student>> {
    return this.http.post<Student>(this.studentsUrl, student, {
      observe: 'response',
    });
  }

  editStudent(student: Student): Observable<HttpResponse<Student>> {
    return this.http.put<Student>(this.studentsUrl, student, {
      observe: 'response',
    });
  }

  deleteStudent(studentId: number): Observable<HttpResponse<any>> {
    const url = `${this.studentsUrl}/${studentId}`;
    return this.http.delete<any>(url, { observe: 'response' });
  }
  getStudentByUsername(username: string): Observable<any> {
    return this.http.get(`${this.studentsUrl}/username/${username}`);
  }
}
