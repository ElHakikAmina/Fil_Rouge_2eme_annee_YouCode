import { Component, OnInit } from '@angular/core';
import { UserService } from '../../Services/User/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: any ={
    email : '',
    password : ''
  };

  constructor (private userService:UserService  , private router: Router){ }

  ngOnInit(): void {}
  login(user: any) {
    this.userService.Login(user)
      .subscribe({
        next: data => {
          const roleUser = data.roleUser
          console.log(roleUser);


          let dashboardRoute = '/'; // Default route for unknown roles
                     if (roleUser === 'Admin') {
                       dashboardRoute = '/dashboardadmin';
                     } else if (roleUser === 'Supplier') {
                       dashboardRoute = '/dashboardsupplier';
                     } else if (roleUser === 'Buyer') {
                       dashboardRoute = '/dashboardbuyer';
                     }


                     this.router.navigate([dashboardRoute]);
          
        },
        error: err => {
          console.error(err);
        }
      });
  }





}
