import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AlteraclientePage } from './alteracliente.page';

describe('AlteraclientePage', () => {
  let component: AlteraclientePage;
  let fixture: ComponentFixture<AlteraclientePage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(AlteraclientePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
