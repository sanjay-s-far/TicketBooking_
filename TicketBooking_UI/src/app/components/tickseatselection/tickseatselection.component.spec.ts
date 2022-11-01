import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TickseatselectionComponent } from './tickseatselection.component';

describe('TickseatselectionComponent', () => {
  let component: TickseatselectionComponent;
  let fixture: ComponentFixture<TickseatselectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TickseatselectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TickseatselectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
