import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../Services/Admin/admin.service';


@Component({
  selector: 'app-dashboardadmin',
  templateUrl: './dashboardadmin.component.html',
  styleUrls: ['./dashboardadmin.component.css']
})

export class DashboardAdminComponent implements OnInit {
  suppliers: any[] = [];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.loadSuppliers();
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
}
