import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { PrincipalPage } from '../principal.page';

@Component({
  selector: 'app-form-etapa-dois',
  templateUrl: './form-etapa-dois.component.html',
  styleUrls: ['./form-etapa-dois.component.scss'],
})
export class FormEtapaDoisComponent  implements OnInit {

  public formDois!: FormGroup;

  public etapa: string = 'Endereço';

  constructor(private formPrincipal: PrincipalPage) {
    this.formDois = this.formPrincipal.getFormEtapaDois();
  }

  ngOnInit(): void {
    
  }

}
