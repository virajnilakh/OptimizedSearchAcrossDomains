import { TestBed, inject } from '@angular/core/testing';

import { DrugsService } from './drugs.service';

describe('DrugsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DrugsService]
    });
  });

  it('should be created', inject([DrugsService], (service: DrugsService) => {
    expect(service).toBeTruthy();
  }));
});
