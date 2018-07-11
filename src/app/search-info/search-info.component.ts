import { DrugsService } from './../drugs.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-info',
  templateUrl: './search-info.component.html',
  styleUrls: ['./search-info.component.css']
})
export class SearchInfoComponent implements OnInit {
  searchItem: {};
  constructor(private route: ActivatedRoute, private service: DrugsService) { }

  ngOnInit() {
    let type = this.route.snapshot.paramMap.get('type');
    let id = this.route.snapshot.paramMap.get('id');
    console.log(type + id);

    if (type === "DRUG") {
      this.service.getDrugById(id)
        .subscribe(response => {
          this.searchItem = response.text();

        }, error => {
          console.log("error");
        });
    } else {
      this.service.getMechanismById(id)
        .subscribe(response => {
          this.searchItem = response.text();

        }, error => {
          console.log("error");
        });
    }

    console.log("ahoy");
  }

}
