import { Component, OnInit } from '@angular/core';
import { mentor } from '../model/mentor';
import { RestAPIService } from '../service/rest-api.service';
import { training } from '../model/training';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-mentor-profile',
  templateUrl: './mentor-profile.component.html',
  styleUrls: ['./mentor-profile.component.css']
})
export class MentorProfileComponent implements OnInit {
  loginUser: string;
  
  userDetails$:mentor;
  restTrainingList$: training[];
  private readonly notifier: NotifierService;
  constructor(private restApi: RestAPIService,
    notifierService: NotifierService) {
      this.notifier=notifierService;
     }

  ngOnInit() {
    
    this.loginUser=sessionStorage.getItem('username');
    console.log(" this.loginUser:"+ this.loginUser);
    this.restApi.getMentorDetailsByName(this.loginUser).subscribe(data => this.userDetails$ =data);
    
    this.loadTrainingDetails();
  }


  loadTrainingDetails(){
    
    this.restApi.getTrainingDetailsForMentor(this.loginUser).subscribe(data => this.restTrainingList$ =data);
    
  }

  approveRequest(techId:number){
    this.restApi.updateStatusforTraining('Approved',techId).subscribe(data => {
      if(data){
          console.log("updated successfully");
          this.showNotification('error', 'Request Submitted successFully');
      }else{
        console.log("update failed");
      }
    });
  }

  rejectRequest(techId:number){
    this.restApi.updateStatusforTraining('Rejected',techId).subscribe(data => {
      if(data){
          console.log("updated successfully");
          this.showNotification('error', 'Request Submitted successFully');
      }else{
        console.log("update failed");
      }
    });
  }

  public showNotification( type: string, message: string ): void {
    this.notifier.notify( type, message );
  }
}
