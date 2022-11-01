import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/classes/loginmodel/login';
import { UsercredentialsService } from 'src/app/services/loginservices/usercredentials.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private usercredential:UsercredentialsService,private router_:Router) { }
   login=new Login()

  ngOnInit(): void {
  }
  submitcredential()
  {
    console.log(this.login);
    this.usercredential.postusercredential(this.login).subscribe((data)=>{
      this.router_.navigate(["/login"]);
    })
    

  }
}
