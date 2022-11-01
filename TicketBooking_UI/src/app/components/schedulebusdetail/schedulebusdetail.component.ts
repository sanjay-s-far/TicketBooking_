import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';

@Component({
  selector: 'app-schedulebusdetail',
  templateUrl: './schedulebusdetail.component.html',
  styleUrls: ['./schedulebusdetail.component.css']
})
export class SchedulebusdetailComponent implements OnInit {
schedulebusdetail:any;
schedule_enable=true;
  router_: any;
  constructor(private ownerservice:OwnersserviceService) { }

  ngOnInit(): void {
    this.ownerservice.getbusdetail().subscribe((data)=>{
        this.schedulebusdetail=data;
    })
  }
  schedule_delete(busId:String)
  {

    this.ownerservice.deletebusdetail(busId).subscribe((data)=>{
      this.router_.navigate(["/schedule_ownercard"]).then(()=>{
        window.location.reload()
      }    )
     
    })
  }
  update_schedule(busId:any)
  {
   console.log(busId)
  
    this.schedule_enable = !this.schedule_enable
    this.ownerservice.update_schedule(busId,this.schedulebusdetail).subscribe((data)=>{
         this.schedulebusdetail=data;
         console.log("bjb",data)
       
    })
   

  }
  
}
