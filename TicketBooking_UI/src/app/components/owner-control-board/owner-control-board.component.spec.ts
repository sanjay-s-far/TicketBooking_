import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerControlBoardComponent } from './owner-control-board.component';

describe('OwnerControlBoardComponent', () => {
  let component: OwnerControlBoardComponent;
  let fixture: ComponentFixture<OwnerControlBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerControlBoardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerControlBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
