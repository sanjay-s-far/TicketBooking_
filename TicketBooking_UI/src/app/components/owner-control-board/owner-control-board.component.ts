import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { OwnersserviceService } from 'src/app/services/ownersservice.service';

@Component({
  selector: 'app-owner-control-board',
  templateUrl: './owner-control-board.component.html',
  styleUrls: ['./owner-control-board.component.css']
})
export class OwnerControlBoardComponent implements OnInit {

  ownerdata:any 
  BusDetail:any=[]
  BusSchedules:any=[]
  length!:number
  displayedColumns: string[] = [ 'from', 'startingTime', 'fairPerSeat','available_status','bookedSeats'];
  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private ownerService:OwnersserviceService,private router_:Router) {
     
    //xthis.dataSource = new MatTableDataSource(users);
   }
 
  ngOnInit(): void { 
    if(!sessionStorage.getItem("OWNER")){
      this.router_.navigate(['admin-owner/login'])
    }
    this.ownerdata = sessionStorage.getItem("OWNER")
    this.ownerService.BusDetailWithSchedules(this.ownerdata).subscribe({
      next: (data)=>{
        this.BusDetail=data.busDetail
        this.dataSource = new MatTableDataSource(data.busSchedules) 
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    })
    
    
  }
 
  
    applyFilter(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
    
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }
    changeStatus(data:any){
      this.ownerService.updataingAvailStatus(data.scheduleID,"AVAILABLE FOR TRAVEL").subscribe({
        next: (data)=>{
         
          this.router_.navigate([this.router_.url]).then(()=>{window.location.reload()})
        },
        error:(err)=>{
          console.log("hello")
        }
      })
    }


}
