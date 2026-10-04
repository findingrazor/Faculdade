import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonHeader, IonToolbar, IonImg, IonContent, IonButton, IonSearchbar, IonList,
  IonItem, IonAvatar, IonLabel, IonSkeletonText, IonCardHeader, IonCard, IonCardTitle,
  IonCardSubtitle, IonCardContent, IonThumbnail, IonInfiniteScroll, IonInfiniteScrollContent
} from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { PokemonService } from '../../service/pokemon-service.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
  standalone: true,
  imports: [IonHeader, IonToolbar, IonImg, IonContent, IonButton, IonSearchbar, IonList,
    IonItem, IonAvatar, IonLabel, IonSkeletonText, IonCardHeader, IonCard, IonCardTitle,
    IonCardSubtitle, IonCardContent, IonThumbnail, IonInfiniteScroll, IonInfiniteScrollContent,
    CommonModule, FormsModule, RouterModule]
})
export class HomePage implements OnInit {
  @ViewChild(IonInfiniteScroll) infinite!: IonInfiniteScroll;
  private offset: number = 0;
  public pokemon: any[] = [];
  constructor(private pokemonService: PokemonService, private cdr: ChangeDetectorRef) { }
  ngOnInit(): void {
    this.load();
  }
  public load(loadMore = false, event?: any) {
    if (loadMore) {
      this.offset += 25;
    } else {
      this.offset = 0;
      this.pokemon = [];
    }

    this.pokemonService.getAll(this.offset).subscribe({
      next: (res) => {

        if (loadMore) {
          this.pokemon = [...this.pokemon, ...res];
        } else {
          this.pokemon = res;
        }

        console.log('Pokemon carregados:', this.pokemon);

        this.cdr.detectChanges();

        if (event) {
          event.target.complete();
        }

        if (this.offset === 125) {
          this.infinite.disabled = true;
        }
      },

      error: (err) => {
        console.error('Erro ao carregar Pokémon:', err);

        if (event) {
          event.target.complete();
        }
      }
    });
  }
  public onSearchChange(e: any) {
    const value = (e.detail.value ?? '').trim().toLowerCase();

    console.log('Pesquisa:', value);

    if (!value) {
      this.load();
      return;
    }

    this.pokemonService.find(value).subscribe({
      next: (res) => {
        this.pokemon = [res];
        this.cdr.detectChanges();
      },

      error: (err) => {
        console.error('Pokémon não encontrado:', err);
        this.pokemon = [];
        this.cdr.detectChanges();
      }
    });
  }
}
