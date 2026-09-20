import { Injectable } from '@angular/core';
import { ITarefa, createITarefa } from '../../models/tarefa.model';
@Injectable({
  providedIn: 'root',
})
export class TarefaService {
  private categorias: string[] = ['domestico', 'pessoal', 'trabalho'];
  private tarefas: ITarefa[] = [];

  constructor() {}

  public getCategorias(): string[] {
    return this.categorias;
  }
  public getAll(): ITarefa[] {
    return this.tarefas;
  }
  public get(id: string): ITarefa {
    const resultado = this.tarefas.find((obj) => {
      return obj.id === id;
    });
    return resultado ? { ...resultado } : createITarefa();
  }
  public add(novaTarefa: ITarefa): ITarefa {
    let uid: string = Date.now().toString(16);

    novaTarefa.id = uid;
    console.log('Salvar --> novaTarefa', novaTarefa);
    this.tarefas.push(novaTarefa);
    return this.tarefas[this.tarefas.length - 1];
  }
  public getIndex(id: string): number {
    const index = this.tarefas.findIndex((obj) => {
      return obj.id === id;
    });
    return index;
  }
  public update(tarefa: ITarefa): ITarefa {
    const index = this.getIndex(tarefa.id);

    if (index >= 0) {
      this.tarefas[index] = tarefa;
      return this.tarefas[index];
    } else {
      return createITarefa();
    }
  }
  public delete(id: string): number {
    const index = this.getIndex(id);
    if (index >= 0) {
      this.tarefas.splice(index, 1);
    }

    return index;
  }
}
