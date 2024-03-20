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
  productId: number = 0; // Initialize with a default value
  product: Product | null = null; // Initialize product as null

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.productId = +params.get('id')!;
      this.loadProduct(this.productId);
    });
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
}
