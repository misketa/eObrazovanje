import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PredavacComponent } from './components/predavac/predavac.component';
import { StudentsComponent } from './components/student/student.component';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';
import { FinansijskaKarticaComponent } from './components/finansijska-kartica/finansijska-kartica.component';
import { LoginComponent } from './components/login/login.component';
//import { StudentComponent } from "./components/student/student.component";
import { GuardService as AuthGuard } from './services/auth/guard.service';

const routes: Routes = [
  { path: '', component: StudentsComponent, canActivate: [AuthGuard] },
  { path: 'students', component: StudentsComponent, canActivate: [AuthGuard] },
  {
    path: 'addStudent',
    component: StudentDetailComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'editStudent/:id',
    component: StudentDetailComponent,
    canActivate: [AuthGuard],
  },
  { path: 'Predavac', component: PredavacComponent, canActivate: [AuthGuard] },
  {
    path: 'finansijska-kartica',
    component: FinansijskaKarticaComponent,
    canActivate: [AuthGuard],
  },
  { path: 'login', component: LoginComponent },
  // {path: 'student',component: StudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
