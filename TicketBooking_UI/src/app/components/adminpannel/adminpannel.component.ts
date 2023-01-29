import { Component, OnInit } from '@angular/core';
import { Busschedule } from 'src/app/classes/busschedule';
import { AdminserviceService } from 'src/app/services/adminservice.service';
import { OwnerspannelComponent } from '../ownerspannel/ownerspannel.component';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';
import { DatePipe } from '@angular/common';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminpannel',
  templateUrl: './adminpannel.component.html',
  styleUrls: ['./adminpannel.component.css'],
})
export class AdminpannelComponent implements OnInit {
  constructor(
    private Adminservice: AdminserviceService,
    private ownerservice: OwnersserviceService,
    private datepipe: DatePipe,
    private router_:Router
  ) {}
  bschedule = new Busschedule();
  allbusdetail: any = [];
  currentdate = new Date();
  specificBusdetail: any = [];
  ToOptions: any = [];
  selectedTeam: String = '';
  values!: String;
  error!:string;
  Fielddate!:any
  current_date!:any

  ngOnInit(): void {
    this.getallbusdetail()
    // if(!sessionStorage.getItem("ADMIN-ALL")){
    //   this.router_.navigate(["admin-owner/login"])
    // }
    
  }

  getallbusdetail(){
    this.ownerservice.getbusdetail().subscribe((date)=>{this.allbusdetail=date})
  }

  onSelected(value: string): void {
    this.selectedTeam = value;
  }

  onsubmit() {
   this.Fielddate = this.datepipe.transform(this.bschedule.startingTime,'hh:mm')
  this.current_date = this.datepipe.transform(this.currentdate,"hh:mm")
  console.log("check "+ this.Fielddate >= this.current_date);
   
    if(this.Fielddate >= this.current_date){
      this.Adminservice.postbusschedule(this.bschedule).subscribe((sch) => {
        Swal.fire('submited sucessfully');
      });
    }else{
      this.error="select diffrent timings"
    }
  }


  onbusname(data: any) {
    this.ownerservice.getbusdetailbyId(data).subscribe((data) => {
      this.specificBusdetail = data.coverage;
    });
  }

  changeOfOptions(data: any) {
    if (data) {
      this.ToOptions = [];
      for (var i in this.specificBusdetail) {
        if (this.specificBusdetail[i] != data) {
          const revisedData = this.specificBusdetail[i];
          this.ToOptions.push(revisedData);
        }
      }
    }
  }
}
