import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/Services/Category/category.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/models/category';


@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {
  categoryId: number = 0; // Initialize categoryId to a default value
  category: Category = {
    id: 0, // Change id to a default value or remove it if it's automatically assigned
    name: ''
  };

  constructor(private categoryService: CategoryService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.params['id']; // Access route parameters using bracket notation
    this.getCategory();
  }

  getCategory(): void {
    this.categoryService.getCategory(this.categoryId)
      .subscribe((category: Category) => this.category = category); // Define type explicitly
  }

  updateCategory(): void {
    this.categoryService.updateCategory(this.category)
      .subscribe(() => {
        console.log('Category updated successfully');
        this.router.navigate(['dashboardadmin']); 
      }, (error: any) => { // Define type explicitly
        console.error('Error updating category:', error);
      });
  }
}
