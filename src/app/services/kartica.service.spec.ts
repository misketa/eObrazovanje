import { TestBed } from '@angular/core/testing';

import { KarticaService } from './kartica.service';

describe('KarticaService', () => {
  let service: KarticaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KarticaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
