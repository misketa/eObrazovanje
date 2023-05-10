import { HttpClient, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const header = {
  headers: new HttpHeaders({
    method: 'POST',
    'Content-Type': 'multipart/mixed;boundary=---',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class UploadService {
  private apiUploadApi = `${environment.apiURL}/api/uploadfile`;

  constructor(private http: HttpClient) {}

  upload(formData: FormData): Observable<HttpEvent<string[]>> {
    return this.http.post<string[]>(`${this.apiUploadApi}/upload`, formData, {
      reportProgress: true,
      observe: 'events',
    });
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.apiUploadApi}/files`);
  }
}
