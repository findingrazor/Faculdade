import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CadastrovendaPage } from './cadastrovenda.page';

describe('CadastrovendaPage', () => {
  let component: CadastrovendaPage;
  let fixture: ComponentFixture<CadastrovendaPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastrovendaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
