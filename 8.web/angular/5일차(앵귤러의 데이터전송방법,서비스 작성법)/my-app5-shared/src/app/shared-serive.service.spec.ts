import { TestBed, inject } from '@angular/core/testing';

import { SharedSeriveService } from './shared-serive.service';

describe('SharedSeriveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SharedSeriveService]
    });
  });

  it('should be created', inject([SharedSeriveService], (service: SharedSeriveService) => {
    expect(service).toBeTruthy();
  }));
});
