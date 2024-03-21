import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseUrl = 'http://localhost:8080/api/User';

  constructor(private http:HttpClient) {  }
  public Login(user:any){
    return this.http.post<any>(`${this.baseUrl}/login`, user);
  }


  activateAccount(validationDto: any): Observable<boolean> {
    return this.http.put<boolean>(`${this.baseUrl}/activateAccount`, validationDto);
  }

  forgetPassword(user: any): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrl}/forgetPassword`, user);
  }

  updatePassword(validationDto: any, newPassword: string): Observable<boolean> {
    return this.http.put<boolean>(`${this.baseUrl}/forgetPassword/${newPassword}`, validationDto);
  }
}
