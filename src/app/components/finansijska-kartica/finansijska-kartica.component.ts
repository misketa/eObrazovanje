import { Component, OnInit } from '@angular/core';
import { KarticaService } from 'src/app/services/kartica.service';
import { FinansijskaKartica } from 'src/app/_model/finansijskaKartica.model';

@Component({
  selector: 'app-finansijska-kartica',
  templateUrl: './finansijska-kartica.component.html',
  styleUrls: ['./finansijska-kartica.component.css'],
})
export class FinansijskaKarticaComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
}
