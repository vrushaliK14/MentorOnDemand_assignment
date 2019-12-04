import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes, Router} from '@angular/router';
import { MatDatepickerModule, MatInputModule,MatNativeDateModule} from '@angular/material';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { RestAPIService } from './service/rest-api.service';
import { MentorComponent } from './mentor/mentor.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown-angular7';
import { componentFactoryName } from '@angular/compiler';
import { AdminComponent } from './admin/admin.component';
import { MentorProfileComponent } from './mentor-profile/mentor-profile.component';
import { NotifierModule, NotifierOptions } from "angular-notifier";

const appRoutes: Routes = [
  {path:'welcome',component:WelcomeComponent},
  {path:'home',component:HomeComponent},
  {path:'mentor/:MentorName',component:MentorComponent},
  {path:'login',component:LoginComponent},
  {path:'logout', component: LogoutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'mentorProfile', component: MentorProfileComponent},
]

/**
 * Custom angular notifier options
 */
const customNotifierOptions: NotifierOptions = {
	position: {
		horizontal: {
			position: 'left',
			distance: 12
		},
		vertical: {
			position: 'top',
			distance: 100,
			gap: 10
		}
	},
	theme: 'material',
	behaviour: {
		autoHide: 5000,
		onClick: false,
		onMouseover: 'pauseAutoHide',
		showDismissButton: true,
		stacking: 4
	},
	animations: {
		enabled: true,
		show: {
			preset: 'slide',
			speed: 300,
			easing: 'ease'
		},
		hide: {
			preset: 'fade',
			speed: 300,
			easing: 'ease',
			offset: 50
		},
		shift: {
			speed: 300,
			easing: 'ease'
		},
		overlap: 150
	}
};

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MentorComponent,
    LoginComponent,
    WelcomeComponent,
    LogoutComponent,
    RegisterComponent,
    AdminComponent,
    MentorProfileComponent    
  ],
  imports: [
    BrowserModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatDatepickerModule, 
    MatInputModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    NgMultiSelectDropDownModule.forRoot(),
    NotifierModule.withConfig( customNotifierOptions )
  ],
 // exports: [RouterModule,Router],
  providers: [RestAPIService],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
