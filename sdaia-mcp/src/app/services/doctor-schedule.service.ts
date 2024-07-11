import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IdStorageService} from "./id-storage-service.service";

@Injectable({
  providedIn: 'root'
})
export class DoctorScheduleService {

  private baseUrl = 'http://DEV-1261.mshome.net:8080/copyMCP/webapi';

  constructor(private http: HttpClient, private idStorageService: IdStorageService) { }

  getAllDoctorsSchedules(): Observable<any[]> {

    const idAll = this.idStorageService.getIdAll();
    // @ts-ignore
    return this.http.get<any[]>(`${this.baseUrl}/Doctor/${idAll}/Schedule`);
  }

  updateSchedule(ScheduleId: number, SCHEDUL_start_time: string, SCHEDUL_end_time: string): Observable<any> {

    const body = { SCHEDUL_start_time: SCHEDUL_start_time, SCHEDUL_end_time: SCHEDUL_end_time };
    return this.http.put<any>(`${this.baseUrl}/Doctor/Schedule/${ScheduleId}`, body);
  }

  addSchedules(SCHEDUL_start_time: string, SCHEDUL_end_time: string): Observable<any> {

    const idAll = this.idStorageService.getIdAll();
    // @ts-ignore
    const body = { SCHEDUL_start_time: SCHEDUL_start_time, SCHEDUL_end_time: SCHEDUL_end_time };
    return this.http.post<any>(`${this.baseUrl}/Doctor/${idAll}/Schedule`, body);
  }
}
