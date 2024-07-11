import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleUpdateModalComponent } from './schedule-update-modal.component';

describe('ScheduleUpdateModalComponent', () => {
  let component: ScheduleUpdateModalComponent;
  let fixture: ComponentFixture<ScheduleUpdateModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScheduleUpdateModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScheduleUpdateModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
