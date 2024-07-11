import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientNewRequstComponent } from './patient-new-requst.component';

describe('PatientNewRequstComponent', () => {
  let component: PatientNewRequstComponent;
  let fixture: ComponentFixture<PatientNewRequstComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientNewRequstComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientNewRequstComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
