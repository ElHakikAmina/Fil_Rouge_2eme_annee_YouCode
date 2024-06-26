import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../Services/Admin/admin.service';
import { CategoryService } from '../../Services/Category/category.service';
import { Category } from 'src/app/models/category';
import {Product} from 'src/app/models/product';
import { ProductService } from 'src/app/Services/Product/product.service';

@Component({
  selector: 'app-dashboardadmin',
  templateUrl: './dashboardadmin.component.html',
  styleUrls: ['./dashboardadmin.component.css']
})

export class DashboardAdminComponent implements OnInit {
  pageTitle: string = 'Dashboard';
  suppliers: any[] = [];
  buyers: any[] =[];
  categories: Category[] = [];
  products: Product[]=[];

  constructor(private productService: ProductService ,private adminService: AdminService, private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.loadSuppliers();
    this.loadBuyers();
    this.loadCategories();
    this.loadProducts();
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

loadProducts():void{
  this.productService.getAllProducts().subscribe(
    (data) => {
      this.products =data;
    },
    (error) => {
      console.error('Error fetching products:', error);
    }
  );
}





deleteProduct(productId: number): void {
  this.productService.deleteProduct(productId).subscribe(
    (result) => {
      if (result) {
        // Product successfully deleted
        // Refresh the product list
        this.loadProducts();
      } else {
        // Failed to delete product
        // Handle error, e.g., display an error message to the user
      }
    },
    (error) => {
      console.error('Error deleting product:', error);
      // Handle error, e.g., display an error message to the user
    }
  );
}


deleteCategory(categoryId: number): void {
  this.categoryService.deleteCategory(categoryId).subscribe(
    (result) => {
      if (result) {
        // Category successfully deleted
        // Refresh the category list
        this.loadCategories();
      } else {
        // Failed to delete category
        // Handle error, e.g., display an error message to the user
      }
    },
    (error) => {
      console.error('Error deleting category:', error);
      // Handle error, e.g., display an error message to the user
    }
  );
}




deleteSupplier(supplierId: number): void {
  this.adminService.deleteById("Supplier",supplierId).subscribe(
    () => {
      // Remove the deleted supplier from the list
      this.suppliers = this.suppliers.filter(supplier => supplier.id !== supplierId);
    },
    (error) => {
      console.error('Error deleting supplier:', error);
    }
  );
}

deleteBuyer(buyerId: number): void {
  this.adminService.deleteById("Buyer",buyerId).subscribe(
    () => {
      // Remove the deleted buyer from the list
      this.buyers = this.buyers.filter(buyer => buyer.id !== buyerId);
    },
    (error) => {
      console.error('Error deleting buyer:', error);
    }
  );
}





}
