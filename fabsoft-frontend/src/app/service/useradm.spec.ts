import { TestBed } from '@angular/core/testing';
import { Useradm } from '../model/useradm';

describe('Useradm', () => {
  let service: Useradm;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Useradm);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
