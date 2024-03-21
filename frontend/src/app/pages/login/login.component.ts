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
    email : String,
    password : String
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





//   login(user: any) {
//     this.userService.Login(user)
//       .subscribe({
//         next: data => {
//           // Extract user ID and role from the response
//           //const userId = data.id;
//           const userRole = data.role;
// console.log(userRole);
//           // Store user ID and role in local storage
//          // localStorage.setItem('userId', userId.toString());
//           localStorage.setItem('userRole', userRole);

//           // Navigate to the desired page after successful login
//           // For example, navigate to the home page
//            // Determine which dashboard to navigate based on the user's role
//            let dashboardRoute = '/'; // Default route for unknown roles
//            if (userRole === 'Admin') {
//              dashboardRoute = '/dashboardadmin';
//            } else if (userRole === 'Supplier') {
//              dashboardRoute = '/dashboardsupplier';
//            } else if (userRole === 'Buyer') {
//              dashboardRoute = '/dashboardbuyer';
//            }
 
//            // Navigate to the appropriate dashboard page after successful login
//            this.router.navigate([dashboardRoute]);
//         },
//         error: err => {
//           console.error(err);
//           // Handle login error
//           // For example, display an error message
//         }
//       });
//     }
}
