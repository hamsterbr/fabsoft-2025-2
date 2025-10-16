import { TestBed } from '@angular/core/testing';

import { Usercomum } from './usercomum';

describe('Usercomum', () => {
  let service: Usercomum;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Usercomum);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
