import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CadastroprodutoPage } from './cadastroproduto.page';

describe('CadastroprodutoPage', () => {
  let component: CadastroprodutoPage;
  let fixture: ComponentFixture<CadastroprodutoPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroprodutoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
