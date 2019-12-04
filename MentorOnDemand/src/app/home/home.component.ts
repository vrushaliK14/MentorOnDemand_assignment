import { Component, OnInit } from '@angular/core';
import { RestAPIService } from '../service/rest-api.service';
import { training } from '../model/training';
import {mentor} from '../model/mentor';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private restApi: RestAPIService) { }
 
  loginUser: string;
  restTrainingList$: training[];
  userDetails$:mentor;

  ngOnInit() {
    this.loginUser=sessionStorage.getItem('username');
    if(this.loginUser === 'admin'){

    }else{
      this.restApi.getTrainingDetailsForUser(this.loginUser).subscribe(data => this.restTrainingList$ =data);

      this.restApi.getMentorDetailsByName(this.loginUser).subscribe(data => this.userDetails$ =data);
    }
  }


  

}
