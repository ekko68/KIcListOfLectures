import { TestBed, inject } from '@angular/core/testing';

import { CustService } from './cust.service';

describe('CustService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CustService]
    });
  });

  it('should be created', inject([CustService], (service: CustService) => {
    expect(service).toBeTruthy();
  }));
});
