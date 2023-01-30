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
@Input() userlogin!:Boolean
seatmap:any = [];
seatChartConfig = {
showRowsLabel: false,
showRowWisePricing: false,
newSeatNoForRow: false
};
cart:any = {
  selectedSeats: [] ,
  seatstoStore: [],
  totalamount: 0,
  cartId: "",
  eventId: 0
};

   constructor(private  ownerservice:OwnersserviceService,private ticketbooking:TicketbookingService) { }

 
  ngOnInit(): void {
    console.log(this.userlogin)
  }
  
 
  public scrollRight() {
    
    this.widgetsContent.nativeElement.scrollTo({ left: (this.widgetsContent.nativeElement.scrollLeft + 400), behavior: 'smooth' });
  }

  public scrollLeft() {
    this.widgetsContent.nativeElement.scrollTo({ left: (this.widgetsContent.nativeElement.scrollLeft - 400), behavior: 'smooth' });
  }
   

  configuration : any = null
  toBeBooked(detail:any){
  //  const totalseats= detail.noOfSeats-detail.bookedSeats

    if(detail == 'seatconfig-1'){  
      this.processSeatChart(seatconfiguration1)

    }else if (detail == 'seatconfig-2'){
      this.processSeatChart(seatconfiguration2)
    } 
   
  }

closing(){
  this.seatmap = []
  this.cart=[]
}
  public processSeatChart(map_data: any[]) {
   
    if (map_data.length > 0) {
      var seatNoCounter = 1;
      for (let __counter = 0; __counter < map_data.length; __counter++) {
        var row_label = "";
        var item_map = map_data[__counter].seat_map;
        row_label = "Row " + item_map[0].seat_label + " - ";
        if (item_map[item_map.length - 1].seat_label != " ") {
          row_label += item_map[item_map.length - 1].seat_label;
        } else {
          row_label += item_map[item_map.length - 2].seat_label;
        }
        row_label += " : Rs. " + map_data[__counter].seat_price;

        item_map.forEach((map_element:any) => {
          var mapObj:any = {
            seatRowLabel: map_element.seat_label,
            seats: [],
            seatPricingInformation: row_label
          };
          row_label = "";
          var seatValArr = map_element.layout.split("");
          
          if (this.seatChartConfig.newSeatNoForRow) {
            seatNoCounter = 1; //Reset the seat label counter for new row
          }
          var totalItemCounter = 1;
          seatValArr.forEach((item:any) => {
            var seatObj:any = {
              key: map_element.seat_label + "_" + totalItemCounter,
              price: map_data[__counter]["seat_price"],
              status: "available"
            };

            if (item != "_") {
              seatObj["seatLabel"] =
                map_element.seat_label + " " + seatNoCounter;
              if (seatNoCounter < 10) {
                seatObj["seatNo"] = "0" + seatNoCounter;
              } else {
                seatObj["seatNo"] = "" + seatNoCounter;
              }

              seatNoCounter++;
            } else {
              seatObj["seatLabel"] = "";
            }
            totalItemCounter++;
            mapObj["seats"].push(seatObj);
          });
          // console.log(" \n\n\n Seat Objects ", mapObj);
          this.seatmap.push(mapObj);
        });
      }
    }
  }
  public selectSeat(seatObject:any) {
    if (seatObject.status == "available") {
      seatObject.status = "booked";
      this.cart.selectedSeats.push(seatObject.seatLabel);
      this.cart.seatstoStore.push(seatObject.key);
      this.cart.totalamount += seatObject.price;
    } else if ((seatObject.status = "booked")) {
      seatObject.status = "available";
      var seatIndex = this.cart.selectedSeats.indexOf(seatObject.seatLabel);
      if (seatIndex > -1) {
        this.cart.selectedSeats.splice(seatIndex, 1);
        this.cart.seatstoStore.splice(seatIndex, 1);
        this.cart.totalamount -= seatObject.price;
      }
    }
  }
 Ticket2BeBooked(){

 }
}


 