import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulebusdetailComponent } from './schedulebusdetail.component';

describe('SchedulebusdetailComponent', () => {
  let component: SchedulebusdetailComponent;
  let fixture: ComponentFixture<SchedulebusdetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SchedulebusdetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulebusdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
