import {Component, OnInit} from '@angular/core';
import {Clothing} from "../../model/Clothing";
import {ClothesBrand} from "../../model/ClothesBrand";
import {DataService} from "../../service/data.service";
import {ClothesCatergory} from "../../model/ClothesCatergory";
import {ClothesService} from "../../service/clothes.service";

@Component({
  selector: 'app-clothing-main',
  templateUrl: './clothing-main.component.html',
  styleUrls: ['./clothing-main.component.css']
})
export class ClothingMainComponent implements OnInit{

  cloths:Clothing=new Clothing();
  dataService:DataService;
  clothesService:ClothesService;
  clothesList:Clothing[]=[];

  constructor(dataService:DataService,clothesService:ClothesService) {
    this.dataService = dataService;
    this.clothesService=clothesService;
  }
  ngOnInit(): void {

    this.clothesService.getAllClothing().subscribe(value => {
      this.clothesList=value;
    })
  }
}
