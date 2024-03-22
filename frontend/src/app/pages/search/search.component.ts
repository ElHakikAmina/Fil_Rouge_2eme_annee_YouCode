
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../Services/Product/product.service'; 
import { Product } from 'src/app/models/product'; 


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  searchQuery: string = ''; 
  searchResults: Product[] = []; 


  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.searchQuery = params['q'];
      if (this.searchQuery) {
        this.searchProducts();
      }
    });
  }

  searchProducts(): void {
    this.productService.searchByNameOrDescription(this.searchQuery).subscribe(
      (results: Product[]) => {
        this.searchResults = results;
      },
      (error) => {
        console.error('Error fetching search results:', error);
        // Handle error, e.g., display an error message to the user
      }
    );
  }


}
