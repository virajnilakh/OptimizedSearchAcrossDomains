import { DrugsService } from './../drugs.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-items',
  templateUrl: './search-items.component.html',
  styleUrls: ['./search-items.component.css']
})
export class SearchItemsComponent implements OnInit {

  private searchItems: any[] = [];

  constructor(private service: DrugsService) { }
  ngOnInit() {

  }
  onClick(id: number) {

  }
  search(searchString: string) {
    this.searchItems = [];
    if (searchString !== ""){
      this.service.getSearchItemsByQuery(searchString)
      .subscribe(response => {
        this.searchItems = response.json();
       
      }, error => {
        console.log("error");
      });
    }
    
  }

}
