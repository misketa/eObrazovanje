import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PredavacComponent } from './components/predavac/predavac.component';
import { StudentsComponent } from './components/student/student.component';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';
import { FinansijskaKarticaComponent } from './components/finansijska-kartica/finansijska-kartica.component';
//import { StudentComponent } from "./components/student/student.component";

const routes: Routes = [
  { path: '', component: StudentsComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'addStudent', component: StudentDetailComponent },
  { path: 'editStudent/:id', component: StudentDetailComponent },
  { path: 'Predavac', component: PredavacComponent },
  { path: 'finansijska-kartica', component: FinansijskaKarticaComponent },
  //{path: 'student',component: StudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
