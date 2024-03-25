import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from 'src/app/Services/Product/product.service';
import { Product } from 'src/app/models/product';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/Services/Category/category.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent {


  product = {
    name : '',
    prix: '',
    less_quantity: '',
    quantity: '',
    description: '',
    image: '',
    category:{
      id:0
    },
    supplier:{
      id:0
    }
  }

  
  categories: Category[] = [];

  constructor(private router:Router, private categoryService: CategoryService , private fb: FormBuilder, private productService: ProductService) {
  }

  ngOnInit(): void {
    this.loadCategories(); 
    const userIdString = localStorage.getItem('idUser'); 
    if (userIdString) {
      this.product.supplier.id = parseInt(userIdString, 10); // Parse the value only if it's not null
    }
  }



  loadCategories(): void {
    this.categoryService.getAllCategories().subscribe(
      (categories: Category[]) => {
        this.categories = categories; // Assign the fetched categories to the component property
      },
      error => {
        console.error('Error loading categories:', error);
        // Handle error, e.g., show an error message
      }
    );
  }




saveProduct(product: any) {

  
  const selectedCategoryId = parseInt((document.getElementById('category') as HTMLSelectElement).value, 10);
  this.product.category.id = selectedCategoryId;

  this.productService.createProduct(product).subscribe(
    response => {
      console.log('Product created successfully:', response);
      // Handle success, e.g., show a success message
      this.router.navigate(['/dashboardsupplier']);
    },
    error => {
      console.error('Error creating product:', error);
      // Handle error, e.g., show an error message
    }
  );
}
 
 

  
}
