import { ThisReceiver } from '@angular/compiler';
import { Component, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AdminserviceService } from 'src/app/services/adminservice.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  adminName!:string;
  adminPassword!:string;
   
  Error!:String;
  constructor(private adminservice:AdminserviceService , private router_:Router) { }

  ngOnInit(): void {

  }

  AdminLogin(){
    
    this.adminservice.loginAdmin(this.adminName.replace(" ",""),this.adminPassword.replace(/ /g,'')).subscribe(
      {
        next: (data)=>{
          console.log(data.role);
          
            if(data.role == "OWNER"){
              sessionStorage.setItem("OWNER",data.adminId)
              this.router_.navigate(["owner/controlboard"])
            }else if(data.role == "ADMIN-ALL"){
              console.log(data);
              // console.log(`the role is ${data.role}`)
                sessionStorage.setItem("ADMIN-ALL",data.adminName)
                this.router_.navigate(["admin/new-schedule"])
            }else if(data.role == "ADMIN-R"){
                sessionStorage.setItem("ADMIN-R",data.adminName)
                this.router_.navigate(["admin/schedules"])
            }else if(data.role == "SUPERADMIN"){
              sessionStorage.setItem("SUPERADMIN",data.adminName)
              this.router_.navigate(["admin/management"])
            }
        },
        error:(err)=>{
          console.log(err)
          if(err.status == 400){
            this.Error = "Wrong Password"
          }else{
            this.Error="check both username and password. Then try again!"
          }
          
        }
      }
    )
  }

}
