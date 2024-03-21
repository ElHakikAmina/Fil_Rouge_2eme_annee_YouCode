import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardsupplierComponent } from './dashboardsupplier.component';

describe('DashboardsupplierComponent', () => {
  let component: DashboardsupplierComponent;
  let fixture: ComponentFixture<DashboardsupplierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DashboardsupplierComponent]
    });
    fixture = TestBed.createComponent(DashboardsupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
