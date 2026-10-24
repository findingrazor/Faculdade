import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CadastroclientePage } from './cadastrocliente.page';

describe('CadastroclientePage', () => {
  let component: CadastroclientePage;
  let fixture: ComponentFixture<CadastroclientePage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroclientePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
