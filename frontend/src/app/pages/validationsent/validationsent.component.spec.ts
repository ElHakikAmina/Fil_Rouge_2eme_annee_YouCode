import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidationsentComponent } from './validationsent.component';

describe('ValidationsentComponent', () => {
  let component: ValidationsentComponent;
  let fixture: ComponentFixture<ValidationsentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ValidationsentComponent]
    });
    fixture = TestBed.createComponent(ValidationsentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
