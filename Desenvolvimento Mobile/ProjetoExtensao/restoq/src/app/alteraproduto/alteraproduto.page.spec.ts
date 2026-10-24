import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AlteraprodutoPage } from './alteraproduto.page';

describe('AlteraprodutoPage', () => {
  let component: AlteraprodutoPage;
  let fixture: ComponentFixture<AlteraprodutoPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(AlteraprodutoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
