import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Booking } from 'src/app/classes/booking';
import { TicketbookingService } from 'src/app/services/Booking/ticketbooking.service';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';
import Swal from "sweetalert2"
import seatconfiguration1 from '../../../assets/seatconfig-json/seatconfig-1.json';
import seatconfiguration2 from '../../../assets/seatconfig-json/seatconfig-2.json';
@Component({
  selector: 'app-buscardlist',
  templateUrl: './buscardlist.component.html',
  styleUrls: ['./buscardlist.component.css']
})

export class BuscardlistComponent implements OnInit {
@Input() schedulelist:any
@ViewChild('widgetsContent') widgetsContent!: ElementRef;
@ViewChild("para") para!:ElementRef;

   constructor(private  ownerservice:OwnersserviceService,private ticketbooking:TicketbookingService) { }

  seatConfiguration1:any;
  seatConfiguration2:any;
  ngOnInit(): void {
    this.seatConfiguration1=seatconfiguration1
    this.seatConfiguration2 = seatconfiguration2
  }
  data!:string 
  busID!:string 
 
  public scrollRight() {
    
    this.widgetsContent.nativeElement.scrollTo({ left: (this.widgetsContent.nativeElement.scrollLeft + 400), behavior: 'smooth' });
  }

  public scrollLeft() {
    this.widgetsContent.nativeElement.scrollTo({ left: (this.widgetsContent.nativeElement.scrollLeft - 400), behavior: 'smooth' });
  }
   
  hello(busid:string){
    this.busID = busid
   
  }

  hello2(busID:any){
 this.ownerservice.getbusdetailbyId(busID).subscribe((req)=>{
      this.data = req.mode
    })
    console.log(this.data)
  }

  booking=new Booking()

  
  toBeBooked(detail:any){
   const totalseats= detail.noOfSeats-detail.bookedSeats
  //   Swal.fire({
  //     title: "Enter the number of seats",
  //     input: 'number',
  //     inputAttributes: {
  //      max: totalseats.toString(),
  //      min:"1",
  //     },
  //     showCancelButton: true,
  //     confirmButtonText: 'Proceed',
  //     showLoaderOnConfirm: true,
  //     preConfirm: (data) => {
        
  //       this.booking.setScheduleID(detail.scheduleID)
  //       this.booking.setNoOfBookingSeats(data)
  //       this.ticketbooking.seatbooking(this.booking).subscribe((data)=>{
  //          console.log(data)
  //       })
  // }})

 
 
        console.log(detail)
   
  }
 
}
 