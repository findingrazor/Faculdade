import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonButtons,
  IonContent,
  IonHeader,
  IonTitle,
  IonToolbar,
  IonButton,
  IonIcon,
  IonAvatar,
  IonInput,
  IonItem,
  IonList,
  IonLabel
} from '@ionic/angular';
import { addIcons } from 'ionicons';
import { arrowForward, arrowBack, pencilOutline } from 'ionicons/icons';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.page.html',
  styleUrls: ['./perfil.page.scss'],
  imports: [
      IonButtons,
      IonContent,
      IonHeader,
      IonTitle,
      IonToolbar,
      IonButton,
      IonIcon,
      IonAvatar,
      IonInput,
      IonItem,
      IonList,
      IonLabel
  ]
})
export class PerfilPage implements OnInit {

  constructor() {
    addIcons({ arrowForward, arrowBack, pencilOutline });
  }

  ngOnInit() {
  }

}
