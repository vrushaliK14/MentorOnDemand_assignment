import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { RestAPIService } from '../service/rest-api.service';
import { stringify } from '@angular/compiler/src/util';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';
  invalidLogin = false;
  isvalidUser:Boolean;
  userRole ='';
  isMentor : any;

  private readonly notifier: NotifierService;
  
  constructor(private router: Router,
    private restApi: RestAPIService,
    private loginservice: AuthenticationService, 
    notifierService: NotifierService) {
      this.notifier=notifierService;
     }
     
  ngOnInit() {
    sessionStorage.setItem('userrole','na');
  }
  
  loginUser(event){
    console.log("hello");
    event.preventDefault();
    console.log(event);
  }
  
  checkLogin() { 
  if(this.loginservice.authenticate(this.username,this.password)){
    sessionStorage.setItem('username',this.username);
      this.invalidLogin = false;
      if(this.username==='admin'){
            this.router.navigate(['/admin']);
      }else{
        this.restApi.isMentor(this.username).subscribe(response => {
          if(response){
            sessionStorage.setItem('userrole','mentor');
            this.router.navigate(['/mentorProfile']);
          }else{
            sessionStorage.setItem('userrole','user');
            this.router.navigate(['/home']);
          }
        });
      }    
    }else{
      this.invalidLogin = true;
      console.log("login failed");
    }  
}

  
  public showNotification( type: string, message: string ): void {
    this.notifier.notify( type, message );
  }

}
