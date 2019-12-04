import { Component, OnInit } from '@angular/core';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';
import { NgForm, FormControl } from '@angular/forms';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
  styleUrls: [`app.component.css`]
  
}
)
export class AppComponent   implements OnInit {

  constructor(private loginService:AuthenticationService) { }
 
  sessionUser:string;
   
  ngOnInit() {
    this.sessionUser= sessionStorage.getItem('username');
  }
  
  
  title = 'MentorOnDemand';

  
}

