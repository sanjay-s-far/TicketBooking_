import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscardlistComponent } from './buscardlist.component';

describe('BuscardlistComponent', () => {
  let component: BuscardlistComponent;
  let fixture: ComponentFixture<BuscardlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscardlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscardlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
