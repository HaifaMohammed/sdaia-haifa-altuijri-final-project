import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IdStorageService} from "./id-storage-service.service";

@Injectable({
  providedIn: 'root'
})
export class DoctorMedicalReportService {

  private baseUrl = 'http://DEV-1261.mshome.net:8080/copyMCP/webapi';

  constructor(private http: HttpClient, private idStorageService: IdStorageService) {
  }

  getAllPatientMR(pid: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/Medical_Report/Patient/${pid}`);
  }

  getPatient(pid: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/Patient/${pid}`);
  }

  getMR(mrId: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/Doctor/Medical_report_search/${mrId}`);
  }

  addMedicalReport(diagnose: string, treatment: string, pid: number): Observable<any> {

    const idAll = this.idStorageService.getIdAll();
    // @ts-ignore
    const body = { diagnose: diagnose, treatment: treatment };
    return this.http.post<any>(`${this.baseUrl}/Doctor/${idAll}/Patient/${pid}/Medical_Report`, body);
  }
}
