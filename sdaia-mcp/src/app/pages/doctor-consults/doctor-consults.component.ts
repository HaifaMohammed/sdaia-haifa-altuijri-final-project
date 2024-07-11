import { Component } from '@angular/core';
import {DoctorConsultService} from "../../services/doctor-consult.service";
import {Router, RouterLink} from "@angular/router";
import {DatePipe, JsonPipe, NgFor} from "@angular/common";

@Component({
  selector: 'app-doctor-consults',
  standalone: true,
  imports: [JsonPipe, NgFor, DatePipe, RouterLink],
  templateUrl: './doctor-consults.component.html',
  styleUrl: './doctor-consults.component.css'
})
export class DoctorConsultsComponent {

  data: any[] = [];

  constructor(private router: Router, private consultsService: DoctorConsultService) {}

  ngOnInit(): void {
    this.consultsService.getAllDoctorsConsults().subscribe(
      (consultations: any[]) => {
        this.data = consultations;
      },
      error => {
        console.error('Error fetching consultations:', error);
      });
  }
}
