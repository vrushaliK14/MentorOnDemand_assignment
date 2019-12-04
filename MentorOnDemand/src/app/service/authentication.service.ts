import { Injectable } from '@angular/core';
import { RestAPIService } from './rest-api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private isLogin:Boolean = false;

  constructor(
    private restApi: RestAPIService) { }

  authenticate(username,password){
    console.log('check authentication for username '+username+ ' and password : '+password );
    if(username == 'admin' && password == 'admin'){
        return true;
    }else {
        return this.restApi.authenticateUser(username,password);
    }
  }
  

  isLoggedIn(){
    let user=sessionStorage.getItem('username');
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }

  isAdmin(){
    if(sessionStorage.getItem('username')==='admin'){
      return true;
    }else{
      return false;
    }
  }

  isMentor(){
    if(sessionStorage.getItem('userrole')==='mentor'){
      return true;
    }else{
      return false;
    }
  }
  
  isUser(){
    if(sessionStorage.getItem('userrole')==='user'){
      return true;
    }else{
      return false;
    }
  }
}
