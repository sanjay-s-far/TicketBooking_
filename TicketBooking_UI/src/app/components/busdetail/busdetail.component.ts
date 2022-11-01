import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Busdetail } from 'src/app/classes/busdetail';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';

@Component({
  selector: 'app-busdetail',
  templateUrl: './busdetail.component.html',
  styleUrls: ['./busdetail.component.css']
})
export class BusdetailComponent implements OnInit {

  constructor(private ownerservice:OwnersserviceService, private _router:Router) { }
  allbusdetail:any=[]
  ngOnInit(): void {
    this.getallbusdetail()
   
  }
  
  getallbusdetail(){
    this.ownerservice.getbusdetail().subscribe((data)=>{
      this.allbusdetail=data    
    })
  }

  deletebyidbusdetail(id:string){
    this.ownerservice.deletebusdetail(id).subscribe((data)=>{
      console.log("data")
    this._router.navigate(["/detail"]).then(()=>{
      window.location.reload()
    }    )
    })
   
  }
}
