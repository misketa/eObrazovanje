import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { File } from './../../model/File.model';
import { UploadService } from './../../services/uploads/upload.service';

@Component({
  selector: 'app-dokument',
  templateUrl: './dokument.component.html',
  styleUrls: ['./dokument.component.css'],
})
export class DokumentComponent implements OnInit {
  files: any[] = [];
  username: string;
  uploadForm: FormGroup;
  uploaded: boolean;
  fileName: string;

  constructor(
    private uploadService: UploadService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    const { username } = JSON.parse(localStorage.getItem('user') || '{}');
    this.username = username;
    this.uploadService
      .getUploads()
      .subscribe(
        (files) =>
          (this.files = files.filter((u) => u.name.split('-')[0] === username))
      );
    this.uploadForm = this.formBuilder.group({
      file: [''],
    });
  }

  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.uploadForm.get('file')?.setValue(file);
      this.uploaded = true;
      this.fileName = file.name;
    }
  }

  onSubmit() {
    console.log('aaaa');
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('file')?.value);
    formData.append('username', this.username);

    this.uploadService.uploadDocuments(formData).subscribe((data) => {
      console.log(formData);
    });
  }
}
