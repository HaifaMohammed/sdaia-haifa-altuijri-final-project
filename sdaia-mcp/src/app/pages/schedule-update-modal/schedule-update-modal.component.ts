import {Component, Inject} from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import {FormsModule} from "@angular/forms";
import { MatDialogModule } from '@angular/material/dialog';
import {MatFormField} from "@angular/material/form-field";


@Component({
  selector: 'app-schedule-update-modal',
  standalone: true,
  imports: [
    FormsModule,
    MatDialogModule,
    MatFormField
  ],
  templateUrl: './schedule-update-modal.component.html',
  styleUrl: './schedule-update-modal.component.css'
})
export class ScheduleUpdateModalComponent
{
  newStartTime: string;
  newEndTime: string;

  constructor(
    public dialogRef: MatDialogRef<ScheduleUpdateModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    // Initialize input fields with current schedule data
    this.newStartTime = data.currentStartTime;
    this.newEndTime = data.currentEndTime;
  }

  updateSchedule(): void {
    // Pass the new start and end times back to the calling component
    this.dialogRef.close({ newStartTime: this.newStartTime, newEndTime: this.newEndTime });
  }

  closeDialog(): void {
    this.dialogRef.close();
  }
}
