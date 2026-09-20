import { Component } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { TarefaService } from '../services/tarefa';
import { ITarefa } from '../../models/tarefa.model';
import { addIcons } from 'ionicons';
import { add } from 'ionicons/icons';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: false,
})
export class HomePage {
  public tarefas: ITarefa[] = [];
  public hoje: number = Date.now();
  constructor(
    private modalCtrl: ModalController,
    private tarefaServ: TarefaService,
  ) {
    addIcons({ add });
  }
  ngOnInit(): void {
    this.listarTarefas();
  }
  public listarTarefas() {
    this.tarefas = this.tarefaServ.getAll();

    console.log(this.tarefas);
  }
  public deletar(id: string) {
    this.tarefaServ.delete(id);
    this.listarTarefas();
  }
  public corPrioridade(prioridade: string) {
    return prioridade === 'alto'
      ? 'danger'
      : prioridade === 'baixo'
        ? 'success'
        : 'warning';
  }
}
