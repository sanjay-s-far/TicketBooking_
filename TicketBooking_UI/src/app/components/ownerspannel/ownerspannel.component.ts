import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Busdetail } from 'src/app/classes/busdetail';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';

@Component({
  selector: 'app-ownerspannel',
  templateUrl: './ownerspannel.component.html',
  styleUrls: ['./ownerspannel.component.css']
})
export class OwnerspannelComponent implements OnInit {

  constructor(private ownerService:OwnersserviceService,private _router:Router) { }
  busdetail = new Busdetail()
  ngOnInit(): void {
    const string="10LS5RS"
  }
Left_row!:number
Right_row!:number
L_Cops!:number
R_Cops!:number
L_select!:String
R_select!:String


  onsubmit(){
    console.log(this.busdetail)
    const seatingschema=`${this.Left_row}-${this.L_Cops}${this.L_select}${this.Right_row}-${this.R_Cops}${this.R_select}`
    this.busdetail.seatingschema=seatingschema
    this.ownerService.PostBusDetail(this.busdetail).subscribe((data)=>{
      this._router.navigate(["/ownerpanel"]).then(()=>{
        window.location.reload()
      }    )
    }
     
    )
  }
  


  
}

