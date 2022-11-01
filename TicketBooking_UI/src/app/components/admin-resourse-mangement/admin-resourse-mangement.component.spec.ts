import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminResourseMangementComponent } from './admin-resourse-mangement.component';

describe('AdminResourseMangementComponent', () => {
  let component: AdminResourseMangementComponent;
  let fixture: ComponentFixture<AdminResourseMangementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminResourseMangementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminResourseMangementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
