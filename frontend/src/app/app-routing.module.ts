import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent} from './pages/login/login.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchComponent } from './pages/search/search.component';
import { SignupComponent} from './pages/signup/signup.component';
import { AppLayoutComponent } from './app-layout/app-layout.component';
import {HomeComponent} from './pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: AppLayoutComponent,
    children: [
      { path: '', component: HomeComponent } ,
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
