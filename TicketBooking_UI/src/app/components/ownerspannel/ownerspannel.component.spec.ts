import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerspannelComponent } from './ownerspannel.component';

describe('OwnerspannelComponent', () => {
  let component: OwnerspannelComponent;
  let fixture: ComponentFixture<OwnerspannelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerspannelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerspannelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
