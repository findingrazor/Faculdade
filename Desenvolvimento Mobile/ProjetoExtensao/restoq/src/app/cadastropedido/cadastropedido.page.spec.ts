import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CadastropedidoPage } from './cadastropedido.page';

describe('CadastropedidoPage', () => {
  let component: CadastropedidoPage;
  let fixture: ComponentFixture<CadastropedidoPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastropedidoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
