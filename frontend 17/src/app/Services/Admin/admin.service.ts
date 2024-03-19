import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8080/api/Admin';

  constructor(private http: HttpClient) {}

  getAll(roleUser: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/all/${roleUser}`);
  }

  getById(roleUser: string, id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/user/${roleUser}/${id}`);
  }

  deleteById(roleUser: string, id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${roleUser}/${id}`);
  }

  create(roleUser: string, object: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/create/${roleUser}`, object);
  }

  update(roleUser: string, object: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/update/${roleUser}`, object);
  }
}
