import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorConsultsComponent } from './doctor-consults.component';

describe('DoctorConsultsComponent', () => {
  let component: DoctorConsultsComponent;
  let fixture: ComponentFixture<DoctorConsultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DoctorConsultsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctorConsultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
