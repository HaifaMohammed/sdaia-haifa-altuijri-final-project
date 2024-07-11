import { TestBed } from '@angular/core/testing';

import { DoctorMedicalReportService } from './doctor-medical-report.service';

describe('DoctorMedicalReportService', () => {
  let service: DoctorMedicalReportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoctorMedicalReportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
