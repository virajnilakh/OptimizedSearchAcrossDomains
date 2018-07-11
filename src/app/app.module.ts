import { SearchInfoComponent } from './search-info/search-info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DrugsService } from './drugs.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SearchItemsComponent } from './search-items/search-items.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchInfoComponent,
    SearchItemsComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot([
      {path:'',component:SearchItemsComponent},
      {path:'search/:id/:type',component:SearchInfoComponent}
    ])
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
