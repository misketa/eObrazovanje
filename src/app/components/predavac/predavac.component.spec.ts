import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PredavacComponent } from './predavac.component';

describe('PredavacComponent', () => {
  let component: PredavacComponent;
  let fixture: ComponentFixture<PredavacComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PredavacComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PredavacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
