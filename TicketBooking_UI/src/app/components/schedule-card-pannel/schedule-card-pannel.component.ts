import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Busschedule } from 'src/app/classes/busschedule';
import { AdminserviceService } from 'src/app/services/adminservice.service';

@Component({
  selector: 'app-schedule-card-pannel',
  templateUrl: './schedule-card-pannel.component.html',
  styleUrls: ['./schedule-card-pannel.component.css']
})
export class ScheduleCardPannelComponent implements OnInit {

  schedule_enable=true;
  Busschedule=new Busschedule();
  name!:string
  ScheduleDetailForm!:FormGroup
  constructor(private adminservice:AdminserviceService, private router_:Router) { }
  
schedulecard:any


  

active: string ="active"
visibility!:boolean;
  ngOnInit(): void {
    // sessionStorage.getItem("ADMIN")?.match("ADMIN-R")
    if(!sessionStorage.getItem("ADMIN-R") || !sessionStorage.getItem("ADMIN-ALL")){
      this.router_.navigate(["/admin-owner/login"])
      this.visibility = true
    }
    this.adminservice.getAllScheduledbs_detail().subscribe((data)=>{
      this.schedulecard=data;
    }
    
    )
    
  }

  schedule_delete(scheduleID:String)
  {
    this.adminservice.busschedule_delete(scheduleID).subscribe((data)=>{
      this.router_.navigate(["admin/schedules"]).then(()=>{
        window.location.reload()
      })
    })
    
  }
  sch_id!:string
  edit_enable(scheduleID:string)
  {
   this.schedule_enable = !this.schedule_enable
    this.sch_id = scheduleID

  }
  scheduleID!:string;
  update_detail(id:String,val:any){
    console.log(val)
    this.adminservice.update_schedule(id,val).subscribe(()=>{
      this.router_.navigate(["admin/schedules"]).then(()=>{window.location.reload()})
     })
  }

}
