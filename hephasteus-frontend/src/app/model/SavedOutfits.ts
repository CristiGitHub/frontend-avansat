import {BasicDto} from "./BasicDto";

export class SavedOutfits{
  id!:string;
  name!:string;
  clothesIds!:string[];
  occasion!:BasicDto;
  season!:BasicDto;
}
