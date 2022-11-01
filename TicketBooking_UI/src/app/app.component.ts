import { Component, HostListener, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter, map } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
  
})
export class AppComponent implements OnInit  {
  ngOnInit(): void {
    
  }
  title = 'ticketbooking';
 
visible:boolean=true;

@HostListener("window:onbeforeunload",["$event"])
    clearLocalStorage(event:any){
        localStorage.removeItem("SUPERADMIN");
    }


  constructor(private router:Router , private route: ActivatedRoute,private titleService: Title) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd),
      map(() => {
          let child = this.route.firstChild;
          while (child) {
              if (child.firstChild) {
                  child = child.firstChild;
              } else if (child.snapshot.data &&    child.snapshot.data['title']) {
                  return child.snapshot.data['title'];
              } else {
                  return null;
              }
          }
          return null;
      })
  ).subscribe( (data: any) => {
      if (data) {
          this.titleService.setTitle(data + '-busbookink');
          data.navbar===true ?this.visible=true:this.visible=false; 
      }
  });

   }
}
