import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormUseradm } from './form-useradm';

describe('FormUseradm', () => {
  let component: FormUseradm;
  let fixture: ComponentFixture<FormUseradm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormUseradm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormUseradm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
