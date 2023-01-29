import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Busschedule } from 'src/app/classes/busschedule';
import { Login } from 'src/app/classes/loginmodel/login';
import { AdminserviceService } from 'src/app/services/adminservice.service';
import { UsercredentialsService } from 'src/app/services/loginservices/usercredentials.service';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit,AfterViewInit {

  fromoption1 = new FormControl('', [Validators.required]);
 
  username:any;
  password!:string
  data: any;
  busschedule=new Busschedule();
  schedulelist:any=null;
  today= new Date();
  buscoverage:any=[]
  if_userpresent=true;
  from!:string 
  to!:string 
  date!:string 
  showmusiccard=true;
  profilerLogo:any;

  constructor(private credential:UsercredentialsService,private Adminservice:AdminserviceService,private Ownerservice:OwnersserviceService, private router_:Router,private usercredential:UsercredentialsService) { }
  ngAfterViewInit(): void {
   let htmlelement:HTMLElement = document.getElementById("loginevent") as HTMLElement;

    if(!localStorage.getItem("loginUser")){
      //htmlelement.click()
      setTimeout(()=>{
      console.log("hello")
        htmlelement.click()},10000
        )
    }
  }
 
  // @ViewChild("loginevent") modal!:ElementRef;

  ngOnInit(): void {
    
    if(localStorage.getItem("loginUser")){
      this.username = localStorage.getItem("loginUser")
      this.profilerLogo= `https://ui-avatars.com/api/?name=${this.username}`
      this.if_userpresent = !this.if_userpresent 
    }
    this.Ownerservice.getcoverage().subscribe((data: any)=>{
      this.buscoverage=data
      console.log(data)
    })
    
  }
  
  getbusschedule()
  {
    
    this.Adminservice.getbusschedule(this.from,this.to,this.date).subscribe((data)=>{
       this.schedulelist=data;
     
       this.showmusiccard=!this.showmusiccard;
    })
  }

 
  logout(event:any){
    if(event){
      localStorage.clear()
      this.router_.navigate([""]).then(() =>{window.location.reload()})
    }
  }

  savefromoption:any=[];
  onfrom(data:any)
  {
    if(data)
    {
      this.savefromoption=[]
      for (var i in this.buscoverage)
      {
        if(this.buscoverage[i]!=data)
        {
          const fromstored=this.buscoverage[i];
          this.savefromoption.push(fromstored);
        }
        else(data='')
        
      }
    }
    console.log(this.buscoverage);
     
    
  }

  reg=new Login()
  login(){
    this.credential.loginUser(this.username,this.password).subscribe({
      next:(data)=>{
        if(data){
        this.router_.navigate([""]).then(()=>{window.location.reload()})
        localStorage.setItem("loginUser",data.name)
        console.log(data.username)
      }},
      error:(err)=>{
        if(err){
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: err.error
          })
        }
      }
    }
        )

  }

  submitcredential()
  {
    console.log(this.reg.password)
   
    this.usercredential.postusercredential(this.reg).subscribe((data)=>{
      localStorage.setItem("loginUser",data.name)
      this.router_.navigate([""]).then(()=>{window.location.reload()});
    })
  }

}
function next(next: any, arg1: any, error: any, arg3: any) {
  throw new Error('Function not implemented.');
}

