import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-nav-dashboard-admin-createcategory',
  templateUrl: './nav-dashboard-admin-createcategory.component.html',
  styleUrls: ['./nav-dashboard-admin-createcategory.component.css']
})
export class NavDashboardAdminCreatecategoryComponent {

  activeButton: string = '';

  setActiveButton(button: string) {
    this.activeButton = button;
  }

  constructor(private router: Router) {}

  deconnexion(): void {
    // Supprimer les informations de l'utilisateur du stockage local
    localStorage.removeItem('roleUser');
    localStorage.removeItem('idUser');
    
    // Rediriger vers la page d'accueil ou une autre page
    this.router.navigate(['/']);
  }

}
