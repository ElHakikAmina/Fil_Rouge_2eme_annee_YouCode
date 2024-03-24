import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavDashboardAdminComponent } from './nav-dashboard-admin.component';

describe('NavDashboardAdminComponent', () => {
  let component: NavDashboardAdminComponent;
  let fixture: ComponentFixture<NavDashboardAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavDashboardAdminComponent]
    });
    fixture = TestBed.createComponent(NavDashboardAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
