import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardbuyerComponent } from './dashboardbuyer.component';

describe('DashboardbuyerComponent', () => {
  let component: DashboardbuyerComponent;
  let fixture: ComponentFixture<DashboardbuyerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DashboardbuyerComponent]
    });
    fixture = TestBed.createComponent(DashboardbuyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
