import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import {training} from '../model/training';
import {mentor} from '../model/mentor';
import { registerUser } from '../model/registerUser';

@Injectable({
  providedIn: 'root'
})
export class RestAPIService {
  appPathURL: string = 'http://localhost:8888/';
  mentorDetailsAPIurl: string = this.appPathURL+'user/findByName';
  saveRegisterUserAPIurl: string = this.appPathURL+'user/save';
  getTechnologyListAPIurl: string =this.appPathURL+'training/fetchTechnologies';
  getMentorListAPIurl: string = this.appPathURL+'user/fetchMentorList';
  authAPIurl: string = this.appPathURL+'user/authenticateUser';
  userRoleAPIurl: string =this.appPathURL+'user/isMentor';

  searchTraininglistByTech: string =this.appPathURL+'training/listByTech';
  searchTraininglistByTechTime: string=this.appPathURL+'training/listByTechTime';
  searchTraininglistByMentorTechTime: string=this.appPathURL+'training/listByMentorTechTime';
  
  getTrainoingDetailsForUser: string=this.appPathURL+'training/trainingDetailsForUser';
  getTrainoingDetailsForMentor: string=this.appPathURL+'training/trainingDetailsForMentor';

  applyForTrainingAPIurl: string=this.appPathURL+'training/applyForTraining';
  updateTrainingStatusAPIurl: string=this.appPathURL+'training/updateTrainingStatus';

  fetchAllUsersAPIurl: string =this.appPathURL+'user/findAll';
  deleteTechnologyAPUurl: string=this.appPathURL+'training/deleteTechonology'

  userDetails: registerUser;
  constructor(private httpClient: HttpClient) {}

    // Http Options
    httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }  

  public getTrainingsByTech(tech: string){
    console.log("fetching API Data: "+this.searchTraininglistByTech);
    var traininglist=this.httpClient.get<training[]>(this.searchTraininglistByTech+'?technology='+tech).pipe(retry(1),catchError(this.handleError));
    console.log("Training list:"+traininglist);
    return traininglist;
  }

  public getTrainingsByTechTime(tech: string,time: string){
    console.log("fetching API Data: "+this.searchTraininglistByTechTime);
    var traininglist=this.httpClient.get<training[]>(this.searchTraininglistByTechTime+'?technology='+tech+'&batchTime='+time).pipe(retry(1),catchError(this.handleError));
    console.log("Training list:"+traininglist);
    return traininglist;
  }

  public getTrainingsByMentorTechTime(tech: string,time: string,mentorName:string){
    console.log("fetching API Data: "+this.searchTraininglistByMentorTechTime);
    var traininglist=this.httpClient.get<training[]>(this.searchTraininglistByMentorTechTime+'?technology='+tech+'&batchTime='+time+'&mentorName='+mentorName).pipe(retry(1),catchError(this.handleError));
    console.log("Training list:"+traininglist);
    return traininglist;
  }



 public getMentorDetailsByName(mentorName: String){
  
  console.log("fetching API Data: "+this.mentorDetailsAPIurl + " for mentorName:"+ mentorName);
  var mentorDetails=this.httpClient.get<mentor>(this.mentorDetailsAPIurl+'?name='+mentorName).pipe(retry(1),catchError(this.handleError));
  console.log("Mentor data fetched"+mentorDetails);
  return mentorDetails;

}

 public createRegisterUser(regUser): Observable<registerUser> {
   console.log("save user details at:"+this.saveRegisterUserAPIurl);
   return this.httpClient.post<registerUser>(this.saveRegisterUserAPIurl , JSON.stringify(regUser), this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  )
}  


public getTechnologyList(){
  
  console.log("technologyList API : "+this.getTechnologyListAPIurl);
  var technologyList=this.httpClient.get(this.getTechnologyListAPIurl).pipe(retry(1),catchError(this.handleError));
  console.log("technologyList fetched"+technologyList);
  return technologyList;

}

public getMentorList(){
  
  console.log("Mentorlist API : "+this.getMentorListAPIurl);
  var mentorList=this.httpClient.get(this.getMentorListAPIurl).pipe(retry(1),catchError(this.handleError));
  console.log("mentorList fetched"+mentorList);
  return mentorList;

}

public authenticateUser(userName: String,password:String){
  console.log('authencation user at :'+this.authAPIurl+'?username='+userName+'&password='+password);
  return this.httpClient.get<Boolean>(this.authAPIurl+'?username='+userName+'&password='+password).pipe(retry(1),catchError(this.handleError));
}


public isMentor(userName:string){
  console.log('checkingif this user is mentor :'+userName);
  console.log('hitting API:'+this.userRoleAPIurl+'?username='+userName);
  return this.httpClient.get(this.userRoleAPIurl+'?username='+userName).pipe(retry(1),catchError(this.handleError));
}

public getTrainingDetailsForUser(username:String){
  console.log("getTrainingDetailsForUser API : "+this.getTrainoingDetailsForUser);
  var technologyList=this.httpClient.get<training[]>(this.getTrainoingDetailsForUser+'?username='+username).pipe(retry(1),catchError(this.handleError));
  console.log("getTrainingDetailsForUser fetched"+technologyList);
  return technologyList;

}


public getTrainingDetailsForMentor(username:String){
  console.log("getTrainingDetailsForUser API : "+this.getTrainoingDetailsForMentor);
  var technologyList=this.httpClient.get<training[]>(this.getTrainoingDetailsForMentor+'?username='+username).pipe(retry(1),catchError(this.handleError));
  console.log("getTrainingDetailsForUser fetched"+technologyList);
  return technologyList;

}


public applyForTraining(trainingDetails): Observable<training> {
  console.log("save training details at:"+this.applyForTrainingAPIurl);
  console.log("saving details with:"+JSON.stringify(trainingDetails));
  return this.httpClient.post<training>(this.applyForTrainingAPIurl , JSON.stringify(trainingDetails), this.httpOptions)
 .pipe(
   retry(1),
   catchError(this.handleError)
 )
}  


public updateStatusforTraining(status: string,techId:number){
  console.log('update training status as :'+status+' for techId: '+techId + 'at URL:' +this.updateTrainingStatusAPIurl);
 return  this.httpClient.get<Boolean>(this.updateTrainingStatusAPIurl+'?status='+status+'&techId='+techId).pipe(retry(1),catchError(this.handleError));
}  


public findAllUserDetails(){
  console.log('Fetching All User details at:'+this.fetchAllUsersAPIurl);
  return  this.httpClient.get<mentor[]>(this.fetchAllUsersAPIurl).pipe(retry(1),catchError(this.handleError));
}

public deleteTechnology(technology:string){
  console.log('deleteTechnology '+technology + 'at URL:' +this.deleteTechnologyAPUurl);
 return  this.httpClient.get<Boolean>(this.deleteTechnologyAPUurl+'?technology='+technology).pipe(retry(1),catchError(this.handleError));
} 


handleError(error) {
  let errorMessage = '';
  if(error.error instanceof ErrorEvent) {
    // Get client-side error
    errorMessage = error.error.message;
  } else {
    // Get server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  window.alert(errorMessage);
  return throwError(errorMessage);
}





}
