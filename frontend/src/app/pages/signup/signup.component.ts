import { Component, OnInit } from '@angular/core';
import { UserService } from '../../Services/User/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'; 
import { RoleUser } from 'src/app/models/role-user.enum';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent{
  
  constructor(private fb: FormBuilder, private userService: UserService) {}

  roleUser : RoleUser = RoleUser.Default

selectRole() {
  const role = document.getElementById('roleUser')
  //@ts-ignore
  const roleValue = role.value
  this.roleUser = roleValue
  if (roleValue == RoleUser.Supplier) {
    const image = document.getElementById('imageForSupplier')
    image?.setAttribute('style' , 'display:block !important')
  } else {
    const image = document.getElementById('imageForSupplier')
    image?.setAttribute('style' , 'display:none !important')
  }
}


  saveUser(user: any) {
    this.userService.signUp(user,this.roleUser).subscribe(
      response => {
        console.log('Product created successfully:', response);
        // Handle success, e.g., show a success message
      },
      error => {
        console.error('Error creating product:', error);
        // Handle error, e.g., show an error message
      }
    );
  }
  user = {
    nom : '',
    prenom: '',
    email: '',
    password: '',
    role_user: '',
    image: ''
  }

 
}