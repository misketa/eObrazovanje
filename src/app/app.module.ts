import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { StudentComponent } from './components/student/student.component';
import { LoginComponent } from './components/login/login.component';
import { PredavacComponent } from './components/predavac/predavac.component';
import { PredmetComponent } from './components/predmet/predmet.component';
import { SmerComponent } from './components/smer/smer.component';
import { IspitComponent } from './components/ispit/ispit.component';
import { FinansijskaKarticaComponent } from './components/finansijska-kartica/finansijska-kartica.component';
import { HeaderComponent } from './components/header/header.component';
import { ButtonComponent } from './components/button/button.component';
import { DokumentComponent } from './components/dokument/dokument.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    LoginComponent,
    PredavacComponent,
    PredmetComponent,
    SmerComponent,
    IspitComponent,
    FinansijskaKarticaComponent,
    HeaderComponent,
    ButtonComponent,
    DokumentComponent
  ],
  imports: [
    RouterModule.forRoot([]),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
