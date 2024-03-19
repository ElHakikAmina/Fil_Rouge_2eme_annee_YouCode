import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseUrl = 'http://localhost:8080/api/User';

  constructor(private http:HttpClient) {  }
  public Login(user:any){
    return this.http.post<any>(`${this.baseUrl}/login`, user);
  }
}
