import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admincred } from 'src/app/classes/admin/admincred';
import { AdminserviceService } from 'src/app/services/adminservice.service';

@Component({
  selector: 'app-admin-resourse-mangement',
  templateUrl: './admin-resourse-mangement.component.html',
  styleUrls: ['./admin-resourse-mangement.component.css']
})

export class AdminResourseMangementComponent implements OnInit {
  admincredential = new Admincred()
  constructor(private adminservice:AdminserviceService,private router_:Router) { }
  AllAdmins:any = []
  visibility!:boolean
  counts:any=[]
  ngOnInit(): void {
    if(!sessionStorage.getItem("SUPERADMIN")){
      this.router_.navigate(["/admin-owner/login"])
       this.visibility = true
    }else{
      this.adminservice.FetchingAllAdmins("ADMIN-R","ADMIN-ALL").subscribe({
        next:(data)=>{
          this.AllAdmins = data
        },
        error:(err)=>{
          console.log(err)
        }
      })
      this.adminservice.managementCounts().subscribe({
        next:(data)=>{
          this.counts = data
          console.log(data)
        },
        error:(err)=>{
          console.log(err)
        }
      })
    }
    
  }

  addingNewAdmin(){
    if(this.admincredential != null){
      this.adminservice.AddingAdmin(this.admincredential).subscribe({
        next:(data)=>{
          this.router_.navigate([this.router_.url]).then(()=>{window.location.reload()})
        }
      })
    }
  }
  DeleteTheAdmin(Id:string){
    this.adminservice.DeletingAdmin(Id).subscribe({
      next:()=>{
        this.router_.navigate([this.router_.url]).then(()=>{window.location.reload()})
      }
    })
  }

}
