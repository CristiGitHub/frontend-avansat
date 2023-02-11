import {Component, Input, OnInit} from "@angular/core";
import {DataService} from "../../service/data.service";
import {Clothing} from "../../model/Clothing";
import {ClothesBrand} from "../../model/ClothesBrand";
import {ClothesCatergory} from "../../model/ClothesCatergory";
import {ClothesService} from "../../service/clothes.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-clothingModal',
  templateUrl: './clothingModal.component.html',
  styleUrls: ['clothingModal.component.css']
})

export class ClothingModalComponent implements OnInit{
   clothing!:Clothing;
   id!:string
   dataService!:DataService;
   clothesService!:ClothesService;

  clothesBrandList:ClothesBrand[]=[];
  clothesCategoryList:ClothesCatergory[]=[];
  constructor(dataService:DataService, clothesService:ClothesService, private activedRoute: ActivatedRoute) {
    this.dataService=dataService;
    this.clothesService=clothesService;
    this.activedRoute.params.subscribe(params=>{
      this.id=params['id'];
      console.log(params['id']);
    })
  }
  ngOnInit(){
   this.dataService.loadDataClothesBrand().subscribe(value => this.clothesBrandList=value);
   this.dataService.loadDataClothesCategory().subscribe(value => this.clothesCategoryList=value);
   if(this.id){
     this.clothesService.getClothing(this.id).subscribe(value => {
       this.clothing=value;
     })
   }
   else{
     this.clothing=new Clothing();
   }

  }

  addColor(){
    this.clothing.colors.push("#FFF");
  }
  onSubmitNewClothes(){
    console.log(this.clothing);
    this.clothesService.postClothing(this.clothing).subscribe((res:Clothing)=>{
      this.clothing=res;
    });
  }
  onUpdateClothes(){
    this.clothesService.putClothing(this.clothing,this.id).subscribe( value => {
      this.clothing=value;
      }
    )
  }


}
