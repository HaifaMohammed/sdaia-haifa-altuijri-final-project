import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IdStorageService} from "./id-storage-service.service";

@Injectable({
  providedIn: 'root'
})
export class DoctorConsultService {

  private baseUrl = 'http://DEV-1261.mshome.net:8080/copyMCP/webapi';

  constructor(private http: HttpClient, private idStorageService: IdStorageService) { }

  getAllDoctorsConsults(): Observable<any[]> {

    const idAll = this.idStorageService.getIdAll();
    // @ts-ignore
    return this.http.get<any[]>(`${this.baseUrl}/Doctor/${idAll}/Consultation`);
  }
}
