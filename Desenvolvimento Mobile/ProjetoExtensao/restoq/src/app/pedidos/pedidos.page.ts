import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonButtons,
  IonContent,
  IonHeader,
  IonMenu,
  IonMenuButton,
  IonTitle,
  IonToolbar,
  IonAvatar,
  IonButton,
  IonIcon,
  IonInput,
  IonCard,
} from '@ionic/angular';
import { addIcons } from 'ionicons';
import {
  checkmarkCircle,
  receipt,
  arrowDown,
  search,
  filter,
  arrowBack,
} from 'ionicons/icons';

@Component({
  selector: 'app-vendas',
  templateUrl: './pedidos.page.html',
  styleUrls: ['./pedidos.page.scss'],
  imports: [
    IonButtons,
    IonButton,
    IonContent,
    IonHeader,
    IonMenu,
    IonMenuButton,
    IonTitle,
    IonToolbar,
    IonAvatar,
    IonIcon,
    IonAvatar,
    IonInput,
    IonCard,
  ],
})
export class PedidosPage implements OnInit {
  constructor() {
    addIcons({
      checkmarkCircle,
      receipt,
      arrowDown,
      search,
      filter,
      arrowBack,
    });
  }

  ngOnInit() {}
}
