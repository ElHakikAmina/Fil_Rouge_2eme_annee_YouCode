import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/Services/Product/product.service';
import { Product } from 'src/app/models/product';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  products:Array<Product> = []
  searchQuery: string = '';
  constructor (private router: Router, private productService:ProductService){}
  ngOnInit(): void {
      this.getAllProducts()
  }
  getAllProducts() {
    this.productService.getAllProducts()
      .subscribe({
        next: data => {
          this.products = data
          console.log(data)
        },
        error: err => {
          console.error(err);
        }
      });
  }




  searchProducts(): void {
    if (this.searchQuery.trim() !== '') {
      // Navigate to the search page with the search query as a parameter
      this.router.navigate(['/search'], { queryParams: { q: this.searchQuery } });
    }
  }
}

























