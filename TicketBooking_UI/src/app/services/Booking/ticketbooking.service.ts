import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketbookingService {
BASE_URL = 'http://localhost:8080'
  constructor(private http:HttpClient) { }
 

  seatbooking(bookingdetail:any):Observable<any>
  {
    return this.http.post<any>(`${this.BASE_URL}/tickets`,bookingdetail)
  }
}
