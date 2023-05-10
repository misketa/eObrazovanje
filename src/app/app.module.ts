import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { StudentsComponent } from './components/student/student.component';
import { PredavacComponent } from './components/predavac/predavac.component';
import { PredmetComponent } from './components/predmet/predmet.component';
import { SmerComponent } from './components/smer/smer.component';
import { IspitComponent } from './components/ispit/ispit.component';
import { FinansijskaKarticaComponent } from './components/finansijska-kartica/finansijska-kartica.component';
import { HeaderComponent } from './components/header/header.component';
import { ButtonComponent } from './components/button/button.component';
import { DokumentComponent } from './components/dokument/dokument.component';
import { AppRoutingModule } from './app-routing.module';
import { PredavacService } from './services/predavac.service';
import {
  HttpClient,
  HttpClientModule,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { TestComponent } from './components/test/test.component';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';
import { HomeComponent } from './components/home/home/home.component';
import { StudentService } from './components/student/student.service';
import { JwtInterceptor } from './services/auth/interceptor.service';
import { AuthService } from './services/auth/auth.service';
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    PredavacComponent,
    PredmetComponent,
    SmerComponent,
    IspitComponent,
    FinansijskaKarticaComponent,
    HeaderComponent,
    ButtonComponent,
    DokumentComponent,
    TestComponent,
    StudentDetailComponent,
    LoginComponent,
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserModule,
  ],
  providers: [
    PredavacService,
    StudentService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true,
    },
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
