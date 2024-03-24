import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/Product';

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/getAllProducts`);
  }

  searchByPrice(price: number): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/searchByPrice/${price}`);
  }

  searchByNameOrDescription(search: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/searchByNameOrDescription/${search}`);
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.baseUrl}/getProduct/${id}`);
  }

  createProduct(product: Product): Observable<any> {
    return this.http.post(`${this.baseUrl}/createProduct`, product);
  }

  updateProduct(product: Product): Observable<any> {
    return this.http.put(`${this.baseUrl}/updateProduct`, product);
  }

  deleteProduct(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.baseUrl}/deleteProduct/${id}`);
  }

  achatProduct(idBuyer: number, idProduct: number, quantity: number): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrl}/achatProduct/${idBuyer}/${idProduct}/${quantity}`, null);
  }

  addToCart(idBuyer: number, idProduct: number, quantity: number): Observable<boolean> {
    console.log(quantity, idProduct, idBuyer)
    return this.http.post<boolean>(`${this.baseUrl}/ajouteraupanier/${idBuyer}/${idProduct}/${quantity}`, null);
  }
}
