
import { Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {DoctorConsultsComponent} from "./pages/doctor-consults/doctor-consults.component";
import {DoctorScheduleComponent} from "./pages/doctor-schedule/doctor-schedule.component";
import {DoctorMedicalReportComponent} from "./pages/doctor-medical-report/doctor-medical-report.component";
import {PatientNewRequstComponent} from "./pages/patient-new-requst/patient-new-requst.component";
import {PatientConsultsComponent} from "./pages/patient-consults/patient-consults.component";

export const routes: Routes =
  [
    {
      path: '',
      redirectTo: 'login',
      pathMatch: 'full',
    },
    {
      path: 'login',
      component: LoginComponent
    },
    {
      path: 'doctor-consults',
      component: DoctorConsultsComponent
    },
    {
      path: 'doctor-schedule',
      component: DoctorScheduleComponent
    },
    {
      path: 'doctor-medical-report/:pid',
      component: DoctorMedicalReportComponent
    },
    {
      path: 'patient-new-requst',
      component: PatientNewRequstComponent
    },
    {
      path: 'patient-consults',
      component: PatientConsultsComponent
    }

  ];
