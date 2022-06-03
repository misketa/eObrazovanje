import { Component, OnInit } from '@angular/core';
import {PredavacService, Predmet} from "../../services/predavac.service";
@Component({
  selector: 'app-predavac',
  templateUrl: './predavac.component.html',
  styleUrls: ['./predavac.component.css']
})
export class PredavacComponent implements OnInit {

  predmeti? : Predmet[];

  constructor(private predavacService: PredavacService) { }

  ngOnInit(): void {
  }

  SviPredmeti(){
    console.log(this.predmeti)
    this.predavacService.getPredmeti(1).subscribe((predmeti)=>{
      this.predmeti = predmeti;
    })
  }

}
