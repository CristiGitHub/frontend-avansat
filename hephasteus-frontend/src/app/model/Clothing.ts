import {ClothesCatergory} from "./ClothesCatergory";
import {ClothesBrand} from "./ClothesBrand";

export class Clothing {
  id!:string;
  name!:string;
  description!:string;
  image!:string;
  colors:string[]=[];
  clothesCategory!:ClothesCatergory;
  clothesBrand!:ClothesBrand;
}
