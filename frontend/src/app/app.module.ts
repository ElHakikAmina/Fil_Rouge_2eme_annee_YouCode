import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchComponent } from './pages/search/search.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { ContactusComponent } from './pages/contactus/contactus.component';
import { HomeComponent } from './pages/home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './components/footer/footer.component';
import { CreateproductComponent } from './pages/createproduct/createproduct.component';
import { CreatecategoryComponent } from './pages/createcategory/createcategory.component';
import { CreatecommentComponent } from './components/createcomment/createcomment.component';
import { ShowcommentsComponent } from './components/showcomments/showcomments.component';
import { DashboardAdminComponent } from './pages/dashboardadmin/dashboardadmin.component';
import { DashboardsupplierComponent } from './pages/dashboardsupplier/dashboardsupplier.component';
import { DashboardbuyerComponent } from './pages/dashboardbuyer/dashboardbuyer.component';
import { ValidateEmailComponent } from './pages/validate-email/validate-email.component';
import { ValidationsentComponent } from './pages/validationsent/validationsent.component';
import { PanierComponent } from './pages/panier/panier.component';
import { PaiementComponent } from './pages/paiement/paiement.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ProductComponent,
    SearchComponent,
    NavbarComponent,
    AppLayoutComponent,
    ContactusComponent,
    HomeComponent,
    FooterComponent,
    CreateproductComponent,
    CreatecategoryComponent,
    CreatecommentComponent,
    ShowcommentsComponent,
    DashboardAdminComponent,
    DashboardsupplierComponent,
    DashboardbuyerComponent,
    ValidateEmailComponent,
    ValidationsentComponent,
    PanierComponent,
    PaiementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
