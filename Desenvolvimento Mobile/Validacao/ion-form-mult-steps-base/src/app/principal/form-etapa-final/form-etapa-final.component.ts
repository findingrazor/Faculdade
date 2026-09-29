import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { PrincipalPage } from '../principal.page';

@Component({
  selector: 'app-form-etapa-final',
  templateUrl: './form-etapa-final.component.html',
  styleUrls: ['./form-etapa-final.component.scss'],
})
export class FormEtapaFinalComponent  implements OnInit {
  public formFinal!: FormGroup;
  public genero: string = "";
  public dataNascimento: string = "";
  public formacaoNivel: string = "";

  public etapa: string = 'Cadastro Concluído';

  constructor(private formPrincipal: PrincipalPage) {
    this.formFinal = this.formPrincipal.multiForm;
    this.genero = this.formPrincipal.multiForm.value.etapaUm.genero === "m"? "Masculino":"Feminino";
    this.dataNascimento = this.formPrincipal.multiForm.value.etapaUm.dataNascimento;
    this.formacaoNivel = this.formPrincipal.multiForm.value.etapaTres.nivel;

    console.log('genero', this.genero);

    console.log('dataNascimento', this.dataNascimento);

    console.log('formFinal.value', this.formFinal.value);

    console.log('formFinal', this.formFinal);
  }

  ngOnInit(): void {
    
  }

}
