import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WomanComponent } from './woman.component';

describe('WomanComponent', () => {
  let component: WomanComponent;
  let fixture: ComponentFixture<WomanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WomanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WomanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
