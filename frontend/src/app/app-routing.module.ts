import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent} from './login/login.component';
import { ProductComponent } from './product/product.component';
import { SearchComponent } from './search/search.component';
import { SignupComponent} from './signup/signup.component';
import { AppLayoutComponent } from './app-layout/app-layout.component';

const routes: Routes = [
  {
    path: '',
    component: AppLayoutComponent,
    children: [
      { path: 'login', component: LoginComponent } ,
      { path : 'product' , component: ProductComponent},
      { path : 'search', component: SearchComponent},
      { path : 'signup', component:SignupComponent}
    ],
  },



 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
