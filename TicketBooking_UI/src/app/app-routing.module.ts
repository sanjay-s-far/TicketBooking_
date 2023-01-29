import {  NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AdminResourseMangementComponent } from './components/admin-resourse-mangement/admin-resourse-mangement.component';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { AdminpannelComponent } from './components/adminpannel/adminpannel.component';
import { BusdetailComponent } from './components/busdetail/busdetail.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { OwnerControlBoardComponent } from './components/owner-control-board/owner-control-board.component';
import { OwnerspannelComponent } from './components/ownerspannel/ownerspannel.component';
import { RegisterComponent } from './components/register/register.component';
import { ScheduleCardPannelComponent } from './components/schedule-card-pannel/schedule-card-pannel.component';
import { SchedulebusdetailComponent } from './components/schedulebusdetail/schedulebusdetail.component';
import { TickseatselectionComponent } from './components/tickseatselection/tickseatselection.component';
import { TicketbookingService } from './services/Booking/ticketbooking.service';

const routes: Routes = [
 {path:'seatchart',component:TickseatselectionComponent},
  {path:'',component:HomepageComponent},
{path:'register' ,component:RegisterComponent},
{path: 'ownerpanel',component:OwnerspannelComponent},
{path:'admin/new-schedule',component:AdminpannelComponent},
{path:'detail',component:BusdetailComponent},
{path:'register',component:RegisterComponent},
{path:'admin/schedules',component:ScheduleCardPannelComponent},
{path:'schedule_ownercard',component:SchedulebusdetailComponent},
{path:'admin-owner/login',component:AdminloginComponent},
{path:'admin/management',component:AdminResourseMangementComponent},
{path:'owner/controlboard',component:OwnerControlBoardComponent}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
