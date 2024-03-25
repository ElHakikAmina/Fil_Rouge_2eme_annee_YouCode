import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavDashboardAdminCreatecategoryComponent } from './nav-dashboard-admin-createcategory.component';

describe('NavDashboardAdminCreatecategoryComponent', () => {
  let component: NavDashboardAdminCreatecategoryComponent;
  let fixture: ComponentFixture<NavDashboardAdminCreatecategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavDashboardAdminCreatecategoryComponent]
    });
    fixture = TestBed.createComponent(NavDashboardAdminCreatecategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
