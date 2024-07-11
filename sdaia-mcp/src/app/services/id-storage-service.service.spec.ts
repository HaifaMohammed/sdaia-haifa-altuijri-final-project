import { TestBed } from '@angular/core/testing';

import { IdStorageServiceService } from './id-storage-service.service';

describe('IdStorageServiceService', () => {
  let service: IdStorageServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IdStorageServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
