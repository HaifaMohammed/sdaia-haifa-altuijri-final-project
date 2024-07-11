import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorMedicalReportComponent } from './doctor-medical-report.component';

describe('DoctorMedicalReportComponent', () => {
  let component: DoctorMedicalReportComponent;
  let fixture: ComponentFixture<DoctorMedicalReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DoctorMedicalReportComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctorMedicalReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
