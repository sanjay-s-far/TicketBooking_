import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { OwnerspannelComponent } from './components/ownerspannel/ownerspannel.component';
import { AdminpannelComponent } from './components/adminpannel/adminpannel.component';

import {HttpClientModule} from "@angular/common/http";
import { BusdetailComponent } from './components/busdetail/busdetail.component';
import { SchedulebusdetailComponent } from './components/schedulebusdetail/schedulebusdetail.component';
import { NavabarComponent } from './components/navabar/navabar.component';
import { RegisterComponent } from './components/register/register.component';
import { BuscardlistComponent } from './components/buscardlist/buscardlist.component';
import { ButttonComponent } from './components/buttton/buttton.component';
import { PaymentComponent } from './components/payment/payment.component';
import { NgxQRCodeModule } from '@techiediaries/ngx-qrcode';
import { HomepageComponent } from './components/homepage/homepage.component';
import { DatePipe } from '@angular/common';
import {  NgxPasswordStrengthMeterModule } from 'ngx-password-strength-meter';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { AdminResourseMangementComponent } from './components/admin-resourse-mangement/admin-resourse-mangement.component';
import { OwnerControlBoardComponent } from './components/owner-control-board/owner-control-board.component';
import { ScheduleCardPannelComponent } from './components/schedule-card-pannel/schedule-card-pannel.component';
import { TickseatselectionComponent } from './components/tickseatselection/tickseatselection.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';



@NgModule({
  declarations: [
    AppComponent,
    OwnerspannelComponent,
    AdminpannelComponent,
    BusdetailComponent,
    SchedulebusdetailComponent,
    NavabarComponent,
    RegisterComponent,
    BuscardlistComponent,
    ButttonComponent,
    PaymentComponent,
    HomepageComponent,
    AdminloginComponent,
    AdminResourseMangementComponent,
    OwnerControlBoardComponent,
    ScheduleCardPannelComponent,
    TickseatselectionComponent,
],
  imports: [
   
    BrowserModule,
    AppRoutingModule,
    FormsModule,HttpClientModule,NgxQRCodeModule,NgxPasswordStrengthMeterModule, BrowserAnimationsModule, MaterialModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule { }
