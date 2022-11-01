import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusdetailComponent } from './busdetail.component';

describe('BusdetailComponent', () => {
  let component: BusdetailComponent;
  let fixture: ComponentFixture<BusdetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusdetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
