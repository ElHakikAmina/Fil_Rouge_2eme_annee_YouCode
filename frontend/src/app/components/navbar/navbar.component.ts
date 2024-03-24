import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{


ngOnInit(): void {
    console.log(this.loggedIn);
}


  loggedIn: any= localStorage.getItem("idUser");

 

  isLoggedIn(): boolean {
    return localStorage.getItem('userId') !== null && localStorage.getItem('roleUser') !== null;
  }

  logout(): void {
    localStorage.removeItem('idUser');
    localStorage.removeItem('roleUser');
    window.location.href='';
  }

  isAdmin(): boolean {  
    return localStorage.getItem('roleUser') === 'Admin'; 
  }

  isSupplier(): boolean { 
    return localStorage.getItem('roleUser') === 'Supplier'; 
  }

  isBuyer(): boolean { 
    return localStorage.getItem('roleUser') === 'Buyer'; 
  }






}
