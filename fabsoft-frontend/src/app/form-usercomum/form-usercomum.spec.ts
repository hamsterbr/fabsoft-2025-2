import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormUsercomum } from './form-usercomum';

describe('FormUsercomum', () => {
  let component: FormUsercomum;
  let fixture: ComponentFixture<FormUsercomum>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormUsercomum]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormUsercomum);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
