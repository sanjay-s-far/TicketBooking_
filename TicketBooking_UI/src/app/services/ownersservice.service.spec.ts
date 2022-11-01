import { TestBed } from '@angular/core/testing';

import { OwnersserviceService } from './ownersservice.service';

describe('OwnersserviceService', () => {
  let service: OwnersserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnersserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
