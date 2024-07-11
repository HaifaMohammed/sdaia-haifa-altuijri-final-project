import { Component } from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {DoctorMedicalReportService} from "../../services/doctor-medical-report.service";
import {DatePipe, JsonPipe, NgFor, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-doctor-medical-report',
  standalone: true,
  imports: [
    JsonPipe,
    NgFor,
    DatePipe,
    RouterLink,
    FormsModule,
    NgIf
  ],
  templateUrl: './doctor-medical-report.component.html',
  styleUrl: './doctor-medical-report.component.css'
})
export class DoctorMedicalReportComponent {
  data: any[] = [];
  datap: any | undefined;
  dataMR: any | undefined;
  mrId: number | undefined;
  newDiagnose: string = '';
  newTreatment: string = '';

  constructor(private route: ActivatedRoute, private mrService: DoctorMedicalReportService) {}


  ngOnInit(): void {
    debugger;

    this.route.params.subscribe(params => {
      const pid = +params['pid']; // Convert route parameter to number


      // Fetch patient details
      this.mrService.getPatient(pid).subscribe(patiens => {
        this.datap = patiens;
        console.log(this.datap);
      });

      // Fetch medical reports for the patient
      this.mrService.getAllPatientMR(pid).subscribe(mrs => {
        this.data = mrs;
        console.log(this.data);
      });

    });
  }

  fetchMR(): void {

    if(this.mrId)
    {
      this.mrService.getMR(this.mrId).subscribe(mr => {
        this.dataMR = mr;
        console.log(this.dataMR);
      });
    }
  }

  addMedicalReport(): void {
    if (this.newDiagnose && this.newTreatment) {
      const pid = this.datap.patient_ID; // Assuming patient details are fetched and there's only one patient

      this.mrService.addMedicalReport(this.newDiagnose, this.newTreatment, pid).subscribe(newReport => {
        // Assuming the service returns the newly added medical report
        this.data.push(newReport);
        this.newDiagnose = '';
        this.newTreatment = '';
      }, error => {
        console.error('Failed to add medical report:', error);
      });
    }
  }

}

