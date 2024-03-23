import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { ProductComponent } from './pages/product/product.component';
import { ContactusComponent } from './pages/contactus/contactus.component';
import { SearchComponent } from './pages/search/search.component';
import { SignupComponent } from './pages/signup/signup.component';
import { CreateproductComponent } from './pages/createproduct/createproduct.component';
import { CreatecategoryComponent } from './pages/createcategory/createcategory.component';
import { DashboardAdminComponent } from './pages/dashboardadmin/dashboardadmin.component';
import { DashboardsupplierComponent } from './pages/dashboardsupplier/dashboardsupplier.component';
import { DashboardbuyerComponent } from './pages/dashboardbuyer/dashboardbuyer.component';
import { ValidateEmailComponent } from './pages/validate-email/validate-email.component';
import { ValidationsentComponent } from './pages/validationsent/validationsent.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component:HomeComponent},
  {path : 'product/:id' , component:ProductComponent},
  {path: 'contactus' , component:ContactusComponent},
  {path: 'search' , component:SearchComponent},
  {path: 'signup' , component:SignupComponent},
  {path: 'createproduct' , component:CreateproductComponent},
  {path: 'createcategory' , component:CreatecategoryComponent},
  {path:'dashboardadmin' , component:DashboardAdminComponent},
  {path: 'dashboardsupplier' , component:DashboardsupplierComponent},
  {path: 'dashboardbuyer', component:DashboardbuyerComponent},
  {path: 'validateemail', component:ValidateEmailComponent},
  {path: 'validationsent', component:ValidationsentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
