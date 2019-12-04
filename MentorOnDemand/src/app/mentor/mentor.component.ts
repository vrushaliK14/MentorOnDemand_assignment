import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestAPIService } from '../service/rest-api.service';
import { mentor } from '../model/mentor';
@Component({
  selector: 'app-mentor',
  templateUrl: './mentor.component.html',
  styleUrls: ['./mentor.component.css']
})
export class MentorComponent implements OnInit {

  restMentorDetails$: mentor=null;
  searchMentorName: String =null;
  constructor(private restApi: RestAPIService,
    private activatedRoute: ActivatedRoute) { 
   }

  ngOnInit() {    
    //this.activatedRoute.params.subscribe( params => console.log(params.MentorName) );
    this.activatedRoute.params.subscribe( params => this.searchMentorName =params.MentorName );
    console.log("fetching data for "+this.searchMentorName);
    this.restApi.getMentorDetailsByName(this.searchMentorName).subscribe(data => this.restMentorDetails$ =data);
  }


}
