import { ThisReceiver } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import seatconfiguration1 from '../../../assets/seatconfig-json/seatconfig-1.json';
import seatconfiguration2 from '../../../assets/seatconfig-json/seatconfig-2.json';
@Component({
  selector: 'app-tickseatselection',
  templateUrl: './tickseatselection.component.html',
  styleUrls: ['./tickseatselection.component.css']
})
export class TickseatselectionComponent implements OnInit {
   
   seatmap:any = [];
    seatChartConfig = {
    showRowsLabel: false,
    showRowWisePricing: false,
    newSeatNoForRow: false
  };
seatconfigmap:any;
  @Input() seatconfig:any;


   constructor(){

   }
  ngOnInit(): void {
    console.log(this.seatconfig)
    // this.processSeatChart(seatconfiguration1)
    if(this.seatconfig == 'seatconfig-1'){
      
      this.seatconfigmap = seatconfiguration1
      this.processSeatChart(seatconfiguration1)
      console.log(this.seatconfig + " " + this.seatconfigmap)
    }
    if(this.seatconfig != null){
      if(this.seatconfig=='seatconfig-1'){
       console.log('logged for seatconfig 1')
      }else if(this.seatconfig == 'seatconfig-2'){
        alert("triggred an alert for seat config 2")
      }
    }
  
  }

seatingmap(){
  if(this.seatconfig != null){
    if(this.seatconfig=='seatconfig-1'){
      alert("triggred an alert for seat config 1")
    }else if(this.seatconfig == 'seatconfig-2'){
      alert("triggred an alert for seat config 2")
    }
  }
}

  public processSeatChart(map_data: any[]) {
    console.log(this.seatconfig)
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

   cart:any = {
    selectedSeats: [] ,
    seatstoStore: [],
    totalamount: 0,
    cartId: "",
    eventId: 0
  };
  seatobject:any;
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
}
