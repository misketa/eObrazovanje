import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { FinansijskaKarticaComponent } from "./components/finansijska-kartica/finansijska-kartica.component";
import { LoginComponent } from "./components/login/login.component"; 
import { PredavacComponent } from "./components/predavac/predavac.component";
import { StudentComponent } from "./components/student/student.component";

const routes: Routes = [
    {path: 'Login', component: LoginComponent},
    {path: 'Predavac',component: PredavacComponent},
    {path: 'student',component: StudentComponent},
    {path: 'finansijska-kartica',component: FinansijskaKarticaComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}