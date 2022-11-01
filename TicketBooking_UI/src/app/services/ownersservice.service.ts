import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Busdetail } from '../classes/busdetail';

@Injectable({
  providedIn: 'root'
})
export class OwnersserviceService {

  constructor(private http:HttpClient) { }
  baseurl = "http://localhost:8080"

  
  PostBusDetail(BusDetail:Busdetail):Observable<any>{
    return this.http.post<any>(`${this.baseurl}/entry/busdetail`,BusDetail)
  }
  getbusdetail():Observable<any>{
    return this.http.get<any>(`${this.baseurl}/getall/getbusdetail`)
  }

  getbusdetailbyId(id:string):Observable<any>{
    return this.http.get<any>(`${this.baseurl}/busdetail/${id}`)
  }

  deletebusdetail(id:String){
    return this.http.delete<any>(`${this.baseurl}/deletedetail/${id}`)
  }

  getcoverage():Observable<any>
  {
    return this.http.get<any>(`${this.baseurl}/getcoverage`)
  }

  update_schedule(id:String,BusDetail:Busdetail):Observable<any>
  {
   return this.http.put<any>(`${this.baseurl}/updatedetail/${id}`,BusDetail)
   
  }
//////ownwer login

  loginowner(BusName:string,busNo:string):Observable<any>
  {
    return this.http.get(`${this.baseurl}/ownerlogin?BusName=${BusName}&busNo=${busNo}`)
  }

  BusDetailWithSchedules(ID:string):Observable<any>{
    return this.http.get<any>(`${this.baseurl}/details/${ID}`)
  }

  
  updataingAvailStatus(scheduleId:string,status:string):Observable<any>{
  
    return this.http.post<any>(`${this.baseurl}/update/${scheduleId}`, status)
  }
}
