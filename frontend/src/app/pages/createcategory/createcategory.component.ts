import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CategoryService } from 'src/app/Services/Category/category.service';



@Component({
  selector: 'app-createcategory',
  templateUrl: './createcategory.component.html',
  styleUrls: ['./createcategory.component.css']
})
export class CreatecategoryComponent {

  saveCategory(category: any) {
    this.categoryService.createCategory(category).subscribe(
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
    category = {
      name:'',
     
    }
    constructor(private fb: FormBuilder, private categoryService: CategoryService) {
      
    }
  

}
