import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tickseatselection',
  templateUrl: './tickseatselection.component.html',
  styleUrls: ['./tickseatselection.component.css']
})
export class TickseatselectionComponent implements OnInit {
   seatConfig: any = null;
   seatmap:any = [];
    seatChartConfig = {
    showRowsLabel: false,
    showRowWisePricing: false,
    newSeatNoForRow: false
  };


   constructor(){

   }
  ngOnInit(): void {
    this.seatConfig = [
      {
        seat_price: 250,
        seat_map: [
          {
            seat_label: "1",
            layout: "g_____"
          },
          {
            seat_label: "2",
            layout: "gg__gg"
          },
          {
            seat_label: "3",
            layout: "gg__gg"
          },
          {
            seat_label: "4",
            layout: "gg__gg"
          },
          {
            seat_label: "5",
            layout: "gg__gg"
          },
          {
            seat_label: "6",
            layout: "gg__gg"
          },
          {
            seat_label: "7",
            layout: "gg__gg"
          },
          {
            seat_label: "8",
            layout: "gggggg"
          }
        ]
      }
    ];
    this.processSeatChart(this.seatConfig);
    
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
          console.log(seatValArr)
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
}
