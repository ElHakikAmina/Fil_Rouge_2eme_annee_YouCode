import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../Services/Admin/admin.service';
import { CategoryService } from '../../Services/Category/category.service';
import { Category } from 'src/app/models/category';

@Component({
  selector: 'app-dashboardadmin',
  templateUrl: './dashboardadmin.component.html',
  styleUrls: ['./dashboardadmin.component.css']
})

export class DashboardAdminComponent implements OnInit {
  suppliers: any[] = [];
  buyers: any[] =[];
  categories: Category[] = [];

  constructor(private adminService: AdminService, private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.loadSuppliers();
    this.loadBuyers();
    this.loadCategories();
  }

  loadSuppliers(): void {
    this.adminService.getAll('Supplier').subscribe(
      (data) => {
        this.suppliers = data;
      },
      (error) => {
        console.error('Error fetching suppliers:', error);
        // Handle error, e.g., display an error message to the user
      }
    );
  }

 
  
  loadBuyers(): void {
    this.adminService.getAll('Buyer').subscribe(
      (data) => {
        this.buyers = data;
      },
      (error) => {
        console.error('Error fetching buyers:', error);
        // Handle error, e.g., display an error message to the user
      }
    );
  }


  loadCategories(): void {
    // Method to load categories
    this.categoryService.getAllCategories().subscribe(
      (data) => {
        this.categories = data;
      },
      (error) => {
        console.error('Error fetching categories:', error);
        // Handle error, e.g., display an error message to the user
      }
    );
  }



}
