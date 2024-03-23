import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  isLoggedIn(): boolean { return localStorage.getItem('userId') !== null; }

  isAdmin(): boolean {  return localStorage.getItem('roleUser') === 'Admin'; }

  isSupplier(): boolean { return localStorage.getItem('roleUser') === 'Supplier'; }

  isBuyer(): boolean { return localStorage.getItem('roleUser') === 'Buyer'; }


}
