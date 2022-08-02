import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  getUploads(): Observable<File[]> {
    return this.http.get<File[]>(`${this.apiUploadApi}/files`);
  }

  uploadDocuments(file: FormData) {
    return this.http.post<any>(`${this.apiUploadApi}/upload`, file);
  }
}
