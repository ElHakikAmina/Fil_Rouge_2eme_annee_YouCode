import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CategoryService } from 'src/app/Services/Category/category.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-createcategory',
  templateUrl: './createcategory.component.html',
  styleUrls: ['./createcategory.component.css']
})
export class CreatecategoryComponent {

  constructor(private router : Router, private fb: FormBuilder, private categoryService: CategoryService) { }

  saveCategory(category: any) {
    this.categoryService.createCategory(category).subscribe(
      response => {
        console.log('Category created successfully:', response);
        // Handle success, e.g., show a success message
        this.router.navigate(['/dashboardadmin'])
      },
      error => {
        console.error('Error creating category:', error);
        // Handle error, e.g., show an error message
       
      }
    );
  }
    category = {
      name:'',
     
    }
    
  

}
