import {
  HttpErrorResponse,
  HttpEvent,
  HttpEventType,
} from '@angular/common/http';
import { saveAs } from 'file-saver';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadService } from './../../services/uploads/upload.service';

@Component({
  selector: 'app-dokument',
  templateUrl: './dokument.component.html',
  styleUrls: ['./dokument.component.css'],
})
export class DokumentComponent implements OnInit {
  filenames: string[] = [];
  username: string = '';
  fileStatus = { status: '', requestType: '', percent: 0 };

  fileInfos?: Observable<any>;

  constructor(private fileuploadingService: UploadService) {}

  ngOnInit(): void {
    const { username } = JSON.parse(localStorage.getItem('user') || '{}');
    this.username = username;
    this.fileuploadingService
      .getFiles()
      .subscribe(
        (files) =>
          (this.fileInfos = files.filter(
            (u) => u.name.split('-')[0] === username
          ))
      );
  }

  onUploadFiles(e): void {
    const files = e.target.files;
    const formData = new FormData();
    for (const file of files) {
      formData.append('files', file, file.name);
    }
    this.fileuploadingService.upload(formData).subscribe(
      (event) => {
        console.log(event);
        this.reportProgress(event);
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      }
    );
  }

  private reportProgress(httpEvent: HttpEvent<string[] | Blob>): void {
    switch (httpEvent.type) {
      case HttpEventType.UploadProgress:
        this.updateStatus(httpEvent.loaded, httpEvent.total!, 'Uploading... ');
        break;
      case HttpEventType.DownloadProgress:
        this.updateStatus(
          httpEvent.loaded,
          httpEvent.total!,
          'Downloading... '
        );
        break;
      case HttpEventType.ResponseHeader:
        console.log('Header returned', httpEvent);
        break;
      case HttpEventType.Response:
        if (httpEvent.body instanceof Array) {
          this.fileStatus.status = 'done';
          for (const filename of httpEvent.body) {
            this.filenames.unshift(filename);
          }
        } else {
          saveAs(
            new File([httpEvent.body!], httpEvent.headers.get('File-Name')!, {
              type: `${httpEvent.headers.get('Content-Type')};charset=utf-8`,
            })
          );
        }
        this.fileStatus.status = 'done';
        break;
      default:
        console.log(httpEvent);
        break;
    }
  }

  private updateStatus(
    loaded: number,
    total: number,
    requestType: string
  ): void {
    this.fileStatus.status = 'progress';
    this.fileStatus.requestType = requestType;
    this.fileStatus.percent = Math.round((100 * loaded) / total);
  }
}
