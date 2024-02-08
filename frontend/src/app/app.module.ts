import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ProductComponent } from './product/product.component';
import { SearchComponent } from './search/search.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { CarouselHomeComponent } from './components/carousel-home/carousel-home.component';
import { ContactusComponent } from './contactus/contactus.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ProductComponent,
    SearchComponent,
    NavbarComponent,
    AppLayoutComponent,
    CarouselHomeComponent,
    ContactusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
