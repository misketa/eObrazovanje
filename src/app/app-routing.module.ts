import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./components/login/login.component"; 
import { PredavacComponent } from "./components/predavac/predavac.component";

const routes: Routes = [
    {path: 'Login', component: LoginComponent},
    {path: 'Predavac',component: PredavacComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}