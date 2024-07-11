import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IdStorageService {

  private idAll: any;

  constructor() { }

  getIdAll(): any {
    return this.idAll;
  }

  setIdAll(id: any): void {
    this.idAll = id;
  }
}
