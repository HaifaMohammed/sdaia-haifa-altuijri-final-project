import { Component } from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {DoctorScheduleService} from "../../services/doctor-schedule.service";
import {JsonPipe, NgFor} from "@angular/common";
import { MatDialog } from '@angular/material/dialog';
import { ScheduleUpdateModalComponent } from '../schedule-update-modal/schedule-update-modal.component';
import {FormsModule, NgForm} from "@angular/forms";


@Component({
  selector: 'app-doctor-schedule',
  standalone: true,
  imports: [JsonPipe, NgFor, RouterLink, FormsModule],
  templateUrl: './doctor-schedule.component.html',
  styleUrl: './doctor-schedule.component.css'
})
export class DoctorScheduleComponent {
  data: any[] = [];

  constructor(private router: Router, private scheduleService: DoctorScheduleService, private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.scheduleService.getAllDoctorsSchedules().subscribe(schedules => {

      this.data = schedules;
      console.log(this.data);

    });
  }

  openUpdateScheduleDialog(scheduleId: number, currentStartTime: string, currentEndTime: string): void {
    const dialogRef = this.dialog.open(ScheduleUpdateModalComponent, {
      width: '400px',
      data: { scheduleId: scheduleId, currentStartTime: currentStartTime, currentEndTime: currentEndTime }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {

        this.scheduleService.updateSchedule(scheduleId, result.newStartTime, result.newEndTime).subscribe(updatedSchedule => {

          const index = this.data.findIndex(schedule => schedule.SCHEDUL_ID === scheduleId);
          if (index !== -1) {
            this.data[index].SCHEDUL_start_time = updatedSchedule.SCHEDUL_start_time;
            this.data[index].SCHEDUL_end_time = updatedSchedule.SCHEDUL_end_time;
          }
        }, error => {
          // Handle error
          console.error('Failed to update schedule:', error);
        });
      }
    });
  }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      const startTime = form.value.startTime;
      const endTime = form.value.endTime;
      this.scheduleService.addSchedules(startTime, endTime).subscribe(newSchedule => {
        this.data.push(newSchedule);
        form.resetForm();
      }, error => {
        console.error('Failed to add schedule:', error);
      });
    }
  }
}
