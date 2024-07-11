import { Component } from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {PatientService} from "../../services/patient.service";
import {DatePipe, NgForOf} from "@angular/common";

@Component({
  selector: 'app-patient-consults',
  standalone: true,
  imports: [
    RouterLink,
    DatePipe,
    NgForOf
  ],
  templateUrl: './patient-consults.component.html',
  styleUrl: './patient-consults.component.css'
})
export class PatientConsultsComponent {

  data: any[] = [];

  constructor(private router: Router, private patientService: PatientService) {}

  ngOnInit(): void {
    this.patientService.getAllPatientConsults().subscribe(
      (consultations: any[]) => {
        this.data = consultations;
      },
      error => {
        console.error('Error fetching consultations:', error);
      });
  }
}
