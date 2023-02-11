import {HttpClient} from "@angular/common/http";
import {of, tap} from "rxjs";
import {Injectable} from "@angular/core";
import {ClothesBrand} from "../model/ClothesBrand";
import {ClothesCatergory} from "../model/ClothesCatergory";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  dataClothesCategory: any;
  dataClothesBrand:any;

  constructor(private http: HttpClient) { }

  loadDataClothesCategory() {
    if (this.dataClothesCategory) {
      return of(this.dataClothesCategory);
    } else {
      return this.http.get<ClothesCatergory[]>('http://localhost:8085/api/v1/ClothesCategoryCategory/all').pipe(tap(data => {
        this.dataClothesCategory = data;
      }));
    }
  }
  loadDataClothesBrand() {
    if (this.dataClothesBrand) {
      return of(this.dataClothesBrand);
    } else {
      return this.http.get<ClothesBrand[]>('http://localhost:8085/api/v1/clothingBrand/all').pipe(tap(data => {
        this.dataClothesBrand = data;
      }));
    }
  }

  getCampaigns(){
    return this.http.get('http://localhost:8085/api/v1/ClothesCategoryCategory/1');
  }
}
