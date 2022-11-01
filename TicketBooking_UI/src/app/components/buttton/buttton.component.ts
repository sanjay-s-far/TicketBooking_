import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-buttton',
  templateUrl: './buttton.component.html',
  styleUrls: ['./buttton.component.css']
})
export class ButttonComponent implements OnInit {
@Input() name!:String
@Input() color!:String

@Output() newEvent = new EventEmitter()
  constructor() { }
  ngOnInit(): void {
  }
  madeAclick(){
    this.newEvent.emit()
  }

}
