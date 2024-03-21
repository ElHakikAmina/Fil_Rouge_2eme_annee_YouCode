import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from 'src/app/Services/Product/product.service';
import { Product } from 'src/app/models/product';


@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent {
saveProduct(product: any) {
  this.productService.createProduct(product).subscribe(
    response => {
      console.log('Product created successfully:', response);
      // Handle success, e.g., show a success message
    },
    error => {
      console.error('Error creating product:', error);
      // Handle error, e.g., show an error message
    }
  );
}
  product = {
    name:String,
    prix: Number,
    less_quantity: Number,
    quantity: Number,
    description: String,
    image: String
  }
  constructor(private fb: FormBuilder, private productService: ProductService) {
    
  }

  
}
