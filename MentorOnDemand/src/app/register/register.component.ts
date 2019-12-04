import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { registerUser } from '../model/registerUser';
import { RestAPIService } from '../service/rest-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  showMsg: boolean = false;

  @Input() registerUserDetails = { userName:'', email: '', password: '',phoneNo:'',address:'',
  userRole:'',time_selectedItems:[],tech_selectedItems:[],experience:''};

  tech_dropdownList = [];
  tech_selectedItems = [];
  tech_dropdownSettings = {};

  time_dropdownList = [];
  time_selectedItems = [];
  time_dropdownSettings = {};
  constructor(private restApi: RestAPIService,
    private router : Router,) { }

  ngOnInit() {
    this.tech_dropdownList = [
      'Java-Core' ,
      'Java-Advance' ,
      'Spring' ,
      'Angular' ,
      'CSS' ,
      'Type Script' ,
      'Java Script' ,
      'HTML' ,
      'Bootstrap' ,
      'PHP' ,
      '.net' 
    ];

    /*this.tech_selectedItems = [
      { item_id: 1, item_text: 'Java-Core' },
      { item_id: 8, item_text: 'HTML' }
    ];*/

    this.tech_selectedItems = [
      'Type Script' ,
      'Java Script'
    ];
    this.tech_dropdownSettings = {
      singleSelection: false,
     // idField: 'item_id',
     // textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.time_dropdownList = [
      '10:00am to 12:00pm',  
      '12:00pm to 02:00pm',  
      '02:00pm to 04:00pm',
      '04:00pm to 06:00pm',
      '06:00pm to 08:00pm' 
    ];

    this.time_selectedItems = [
      '10:00am to 12:00pm', 
      '12:00pm to 02:00pm'
    ];

    this.time_dropdownSettings = {
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  SaveRegisterUser(registerUser:NgForm) {
    
    console.log("selected values :"+JSON.stringify(this.registerUserDetails));
    this.restApi.createRegisterUser(this.registerUserDetails);//.subscribe((date:{})=>{this.router.navigate(['/home'])});
    this.showMsg= true;
    //registerUser.reset();
    //this.router.navigate(['/home']);
  }

}
