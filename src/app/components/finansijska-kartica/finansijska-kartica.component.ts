import { Component, OnInit } from '@angular/core';
import { KarticaService } from 'src/app/services/kartica.service';
import { FinansijskaKartica } from 'src/app/_model/finansijskaKartica.model';

@Component({
  selector: 'app-finansijska-kartica',
  templateUrl: './finansijska-kartica.component.html',
  styleUrls: ['./finansijska-kartica.component.css']
})
export class FinansijskaKarticaComponent implements OnInit {
  kartica?: FinansijskaKartica;
  iznos:number=0;
  poruka:string="";
  constructor(private karticaService:KarticaService) { }

  ngOnInit(): void {
    this.karticaService.getKartica().subscribe((kartica)=>{
      this.kartica = kartica
    })
  }
  Uplati(){
    console.log(this.iznos);
    if(this.iznos && this.iznos>0){
      
      this.karticaService.Uplati(this.iznos).subscribe((uplata)=>{

        console.log(uplata)
        this.poruka="Uplaceno"
      }, error=>{
        console.log(error)
        this.poruka="Greska"
      });
    }
  }

}
