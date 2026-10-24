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
import { arrowDown, search, arrowBack, pencil } from 'ionicons/icons';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.page.html',
  styleUrls: ['./clientes.page.scss'],
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
export class ClientesPage implements OnInit {
  constructor() {
    addIcons({
      arrowDown,
      search,
      arrowBack,
      pencil,
    });
  }

  ngOnInit() {}
}
