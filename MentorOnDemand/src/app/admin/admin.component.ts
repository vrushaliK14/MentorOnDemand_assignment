import { Component, OnInit } from '@angular/core';
import { RestAPIService } from '../service/rest-api.service';
import { mentor } from '../model/mentor';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  technologies: any = [];
  userList :mentor[];
  private readonly notifier: NotifierService;
  constructor(
    private restApi: RestAPIService,
    notifierService: NotifierService
              ) {
                this.notifier=notifierService;
    }

  ngOnInit() {
    this.restApi.getTechnologyList().subscribe(data => {
      this.technologies =data;
    }
      
    );
    this.restApi.findAllUserDetails().subscribe(data=> this.userList=data);
  }

  deleteTechnology(technology :string){
    this.restApi.deleteTechnology(technology).subscribe(response=>{
      if(response){
        this.showNotification('success','deleted Successfully');
      }else{
        this.showNotification('error','some error occured');
      }
    })
  }

  public showNotification( type: string, message: string ): void {
    this.notifier.notify( type, message );
  }
 
}
