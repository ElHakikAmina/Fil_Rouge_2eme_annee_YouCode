import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-dashboard-admin',
  templateUrl: './nav-dashboard-admin.component.html',
  styleUrls: ['./nav-dashboard-admin.component.css']
})
export class NavDashboardAdminComponent {

  constructor(private router: Router) {}

  deconnexion(): void {
    // Supprimer les informations de l'utilisateur du stockage local
    localStorage.removeItem('roleUser');
    localStorage.removeItem('idUser');
    
    // Rediriger vers la page d'accueil ou une autre page
    this.router.navigate(['/']);
  }

}
