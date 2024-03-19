import { Component, OnInit } from '@angular/core';
import { UserService } from '../../Services/User/user.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: any;

  constructor (private userService:UserService ){ }

  ngOnInit(): void {}
  login(user: any) {
    this.userService.Login(user)
      .subscribe({
        next: data => {
          this.user = data
          console.log(data)
        },
        error: err => {
          console.error(err);
        }
      });
  }
}
