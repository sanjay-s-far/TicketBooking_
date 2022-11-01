
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admincred } from '../classes/admin/admincred';
import { Busschedule } from '../classes/busschedule';



@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  constructor(private http:HttpClient) { }
  baseurl = "http://localhost:8080"

  postbusschedule(Busschedule:Busschedule):Observable<any>
  {
    return this.http.post<any>(`${this.baseurl}/busschedule`,Busschedule)
  }

  getbusschedule(from:string,to:string,date:String):Observable<any>
  {
    return this.http.get<any>(`${this.baseurl}/from=${from}/to=${to}/${date}`)
  }
  getAllScheduledbs_detail():Observable<any>{
    return this.http.get<any>(`${this.baseurl}/getbusschedule`)
  }

  busschedule_delete(id:String){
    return this.http.delete<any>(`${this.baseurl}/deleteschedule/${id}`)
  }

  update_schedule(id:String,Busschedule:Busschedule):Observable<any>
  {
   return this.http.put<any>(`${this.baseurl}/updateidschedule/${id}`,Busschedule)
  }

  loginAdmin(adminname:string,adminPswd:string):Observable<any>{
   
    return this.http.get<any>(`${this.baseurl}/admin/login?adminName=${adminname}&adminPswd=${adminPswd}`)
  }

  AddingAdmin(Credentails:Admincred){
    return this.http.post<any>(`${this.baseurl}/admin/management`,Credentails)
  }

  FetchingAllAdmins(role1:string,role2:string):Observable<any>{
    return this.http.get<any>(`${this.baseurl}/admin/management?role1=${role1}&role2=${role2}`)
  }

  DeletingAdmin(Id:string):Observable<any>{
    return this.http.delete<any>(`${this.baseurl}/admin/delete/${Id}`)
  }

  
  managementCounts():Observable<any>{
    return this.http.get<any>(`${this.baseurl}/util/counts`)
  }

}
