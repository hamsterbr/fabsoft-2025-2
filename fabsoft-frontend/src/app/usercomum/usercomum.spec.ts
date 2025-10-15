import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Usercomum } from './usercomum';

describe('Usercomum', () => {
  let component: Usercomum;
  let fixture: ComponentFixture<Usercomum>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Usercomum]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Usercomum);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
