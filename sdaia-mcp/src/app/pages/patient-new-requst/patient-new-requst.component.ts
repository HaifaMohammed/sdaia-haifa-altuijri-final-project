import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {PatientService} from "../../services/patient.service";
import {NgForOf, JsonPipe, NgFor, NgIf} from "@angular/common";

@Component({
  selector: 'app-patient-new-requst',
  standalone: true,
  imports: [
    RouterLink,
    NgForOf,
    FormsModule,
    ReactiveFormsModule,
    JsonPipe,
    NgFor,
    NgIf
  ],
  templateUrl: './patient-new-requst.component.html',
  styleUrl: './patient-new-requst.component.css'
})
export class PatientNewRequstComponent {
  protected date: any[] = [];
  filteredData: any[] = [];
  search: String = '';

  constructor(private patientserver: PatientService) {
  }

  ngOnInit(): void {
    this.patientserver.getAllDoctors().subscribe(doctors => {
      this.date = doctors;
      this.filteredData = this.date;
      //console.log(this.data);
    })
  }

  filterall(): void {
    if (this.search.trim() === '') {
      this.filteredData = this.date;
    } else {
      const search = this.search.trim().toLowerCase();
      this.filteredData = this.date.filter(doctor =>
        doctor.doctor_ID.toString().include(search) ||
        doctor.doctor_first_name.toLowerCase().include(search) ||
        doctor.doctor_specialty.toLowerCase().include(search)
      )
    }
  }

  addConsults(doctorId: number): void {
    this.patientserver.addConsults(doctorId).subscribe(
      () => {
        // Optional: Perform any actions upon successful addition of consult
        console.log(`Consult requested with doctor ID ${doctorId}`);
      },
      error => {
        console.error('Failed to request consult:', error);
        // Optional: Handle error scenarios
      }
    );
  }

}

