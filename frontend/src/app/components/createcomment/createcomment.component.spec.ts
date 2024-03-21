import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatecommentComponent } from './createcomment.component';

describe('CreatecommentComponent', () => {
  let component: CreatecommentComponent;
  let fixture: ComponentFixture<CreatecommentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatecommentComponent]
    });
    fixture = TestBed.createComponent(CreatecommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
