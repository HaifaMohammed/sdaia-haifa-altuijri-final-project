import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {IdStorageService} from "../../services/id-storage-service.service";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginObject: Login;
  resultObject: Results;
  // id: number | undefined;

  constructor(private http: HttpClient, private router: Router, private idStorageService: IdStorageService ) {

    this.loginObject = new Login();
    this.resultObject = new Results();
  }

  onLogin(): void {
    debugger;

    this.http.post('http://DEV-1261.mshome.net:8080/copyMCP/webapi/Login', this.loginObject).subscribe((res: any)=> {

      this.resultObject = res;

      const idAll = this.resultObject.id;
      this.idStorageService.setIdAll(idAll);

      if(this.resultObject.type === "Doctor")
      {
        alert("login success");
        this.router.navigateByUrl('/doctor-consults');
      }
      else if(this.resultObject.type === "Patient")
      {
        alert("login success");
        this.router.navigateByUrl('/patient-new-requst');
      }
      else
      {
        alert("invalid data");
      }
      });

  }
}

export class Login{
  LOGIN_email: String;
  LOGIN_password: String;

  constructor() {
    this.LOGIN_email = '';
    this.LOGIN_password = '';
  }
}
export class Results {
  id: number;
  type: String;

  constructor() {
    this.id = 0;
    this.type = '';
  }
}
