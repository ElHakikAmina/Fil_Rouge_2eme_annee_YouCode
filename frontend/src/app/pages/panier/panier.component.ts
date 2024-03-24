import { Component, OnInit } from '@angular/core';
import { PanierService } from 'src/app/Services/Panier/panier.service';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit{
  products: Product[] = [];

  constructor(private panierService: PanierService) { }
  
  ngOnInit(): void {
    this.getPanierProducts();
  }


  getPanierProducts(): void {
    const buyerId = localStorage.getItem('idUser'); // Retrieve buyerId from local storage
    if (buyerId) {
      this.panierService.getPanierProductsByBuyerId(Number(buyerId))
        .subscribe(products => this.products = products);
    } else {
      // Handle case when buyerId is not found in local storage
      console.error('Buyer ID not found in local storage.');
    }
  }

  
}
