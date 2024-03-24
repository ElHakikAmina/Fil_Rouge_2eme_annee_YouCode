import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
import { Product } from 'src/app/models/product';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  private baseUrl = 'http://localhost:8080/api/Product';

  constructor(private http: HttpClient) { }

  getPanierProductsByBuyerId(buyerId: number): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/getPanierProductsByBuyerId/${buyerId}`);
  }
}
