import { TestBed } from '@angular/core/testing';

import { DoctorConsultService } from './doctor-consult.service';

describe('DoctorConsultService', () => {
  let service: DoctorConsultService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoctorConsultService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
