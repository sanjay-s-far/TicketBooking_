import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleCardPannelComponent } from './schedule-card-pannel.component';

describe('ScheduleCardPannelComponent', () => {
  let component: ScheduleCardPannelComponent;
  let fixture: ComponentFixture<ScheduleCardPannelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleCardPannelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleCardPannelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
