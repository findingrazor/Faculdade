import { Component, OnInit, CUSTOM_ELEMENTS_SCHEMA, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonHeader, IonToolbar, IonContent, IonList, 
  IonItem, IonLabel, IonCardHeader, IonCard, IonCardTitle, 
  IonCardSubtitle, IonCardContent, IonBackButton, IonChip, IonButtons } from '@ionic/angular';
import { ActivatedRoute } from '@angular/router';
import { PokemonService } from '../../service/pokemon-service.service';

@Component({
  selector: 'app-detalhes',
  templateUrl: './detalhes.page.html',
  styleUrls: ['./detalhes.page.scss'],
  standalone: true,
  imports: [IonHeader, IonToolbar, IonContent, IonList, 
    IonItem, IonLabel, IonCardHeader, IonCard, IonCardTitle, 
    IonCardSubtitle, IonCardContent, IonBackButton, IonChip, IonButtons, CommonModule, FormsModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DetalhesPage implements OnInit {

  public pokemon: any;

  constructor(private pokemonService: PokemonService, private rotaAtiva: ActivatedRoute,
  private cdr: ChangeDetectorRef) { }

  ngOnInit() {
    
    const index = Number(this.rotaAtiva.snapshot.paramMap.get('id'));
     console.log('ID recebido pela rota:', index);

  this.pokemonService.getDetails(index).subscribe({
    next: (details) => {
      console.log('DETALHES RECEBIDOS:', details);
      this.pokemon = details;
      this.cdr.detectChanges();
    },
    error: (err) => {
      console.error('ERRO AO BUSCAR DETALHES:', err);
    }
  });
    this.pokemonService.getDetails(index).subscribe((details) => {
      this.pokemon = details;
    });
  }
}
