import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/Services/Product/product.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../models/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  productId: number = 0; 
  buyerId: number =0;
  product: Product | null = null; 

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.productId = +params.get('id')!;
      this.loadProduct(this.productId);
    });

      // Retrieve the buyer ID from localStorage
      const buyerIdString = localStorage.getItem('idUser');
      if (buyerIdString !== null) {
        this.buyerId = +buyerIdString;
      } else {
        // Handle the case when buyerId is not available
      }

  }

  loadProduct(id: number): void {
    this.productService.getProduct(id).subscribe(product => {
      this.product = product;
    });
  }

  // Ensure that the quantity property is defined to avoid TS2532 error
  isProductAvailable(): boolean {
    return !!this.product && this.product.quantity > 0;
  }



  addToPanier() {
    const panierItem = {
      idBuyer: this.buyerId,
      idProduct: this.productId,
      quantity: 10 // You may adjust the quantity as needed
    };

    


    this.productService.addToCart(panierItem.idBuyer, panierItem.idProduct, panierItem.quantity).subscribe(
      (response: any) => {
        console.log('Product added to cart successfully:', response);
        // Handle success, e.g., show a success message
      },
      (error: any) => {
        console.error('Error adding product to cart:', error);
        // Handle error, e.g., show an error message
      }
    );
  }




}
