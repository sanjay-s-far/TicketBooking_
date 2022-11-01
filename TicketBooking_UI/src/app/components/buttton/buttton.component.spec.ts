import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButttonComponent } from './buttton.component';

describe('ButttonComponent', () => {
  let component: ButttonComponent;
  let fixture: ComponentFixture<ButttonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ButttonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ButttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
