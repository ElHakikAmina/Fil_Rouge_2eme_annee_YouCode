import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavDashboardAdmin2Component } from './nav-dashboard-admin2.component';

describe('NavDashboardAdmin2Component', () => {
  let component: NavDashboardAdmin2Component;
  let fixture: ComponentFixture<NavDashboardAdmin2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavDashboardAdmin2Component]
    });
    fixture = TestBed.createComponent(NavDashboardAdmin2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
