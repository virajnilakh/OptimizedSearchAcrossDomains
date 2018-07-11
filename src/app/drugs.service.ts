import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class DrugsService {
  private url = 'http://localhost:8080/search/';
  private drugUrl = 'http://localhost:8080/drugs/';
  private mechanismUrl = 'http://localhost:8080/mechanisms/';

  constructor(private http: Http) { }

  getSearchItemsByQuery(searchString: string) {
    return this.http.get(this.url + searchString);
  }
  getDrugById(id:string){
    return this.http.get(this.drugUrl+id);
  }
  getMechanismById(id:string){
    return this.http.get(this.mechanismUrl+id);
  }
  
}
