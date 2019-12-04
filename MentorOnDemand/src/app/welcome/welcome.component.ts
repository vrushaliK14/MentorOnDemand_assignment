import { Component, OnInit } from '@angular/core';
import {training} from '../model/training';
import {RestAPIService} from '../service/rest-api.service';
import { NgForm } from '@angular/forms';
import { Router }  from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { AuthenticationService } from '../service/authentication.service';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent  implements OnInit {
  technologies: any = [];
  mentors: any = [];
  restTrainingList$: training[];
  loginUser: string;
  private readonly notifier: NotifierService;
  
  ngOnInit() {
    this.restApi.getTechnologyList().subscribe(data => this.technologies =data);
    this.restApi.getMentorList().subscribe(data => this.mentors =data);
    this.loginUser=sessionStorage.getItem('username');
    
  }

 
  constructor(private restApi: RestAPIService,
              private router : Router,
              private loginservice: AuthenticationService,
              notifierService: NotifierService
              ) {
                this.notifier=notifierService;
              }
  
  searchTraining(searchTrainingForm:NgForm){
    console.log("select values :"+JSON.stringify(searchTrainingForm.value));
     
    var technology=searchTrainingForm.value.technology;
    var batchTime=searchTrainingForm.value.schedule;
    var mantorName=searchTrainingForm.value.mentor;
    console.log('technology'+technology+' batchTime:'+batchTime + ' mantorName'+mantorName);
    if( (batchTime !== undefined && batchTime !== "") 
        && (technology!== undefined && technology!=="")
        && (mantorName!==undefined && mantorName!=="") ){
      console.log("getting list by all");
      this.restApi.getTrainingsByMentorTechTime(technology,batchTime,mantorName).subscribe(data => this.restTrainingList$ =data);
    }else if ((batchTime !== undefined && batchTime !== "") 
           && (technology!== undefined && technology!=="")){
      console.log("getting list by two");
      this.restApi.getTrainingsByTechTime(technology,batchTime).subscribe(data => this.restTrainingList$ =data);
    }else if (technology!== undefined && technology!==""){
      console.log("getting list by one");
      this.restApi.getTrainingsByTech(technology).subscribe(data => this.restTrainingList$ =data);
    }
    
  }

  getTechnologies(){
    this.restApi.getTechnologyList().subscribe(data => this.technologies =data);
  }

  getMentorList(){
    this.restApi.getMentorList().subscribe(data => this.mentors =data);
  }

  getMentorDetails(mentorName: String){
    this.router.navigate(['mentor',mentorName]);
  }

  applicationStatus:any;
  
  applyForTraining(selectTraining:training){
    console.log('apply for training for user :'+this.loginUser);
        if(this.loginUser !== null){
        console.log("apply training for user : "+this.loginUser);
        selectTraining.userName=this.loginUser;
        this.restApi.applyForTraining(selectTraining).subscribe(response =>{
        if(response){
          console.log("updated succssfully");
          this.showNotification('error', 'Request Submitted successFully');
        }else{
          console.log("error while update");
          this.showNotification('error', 'Sorry ! Some error occured.. please try after some time');
        }
        });
      }else{
        this.showNotification('error','Please login to apply for training');
      }
     
      
    
   
  }

  public showNotification( type: string, message: string ): void {
    this.notifier.notify( type, message );
  }
 
}
