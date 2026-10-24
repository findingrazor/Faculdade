import { Component, OnInit, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
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
  IonCard
} from '@ionic/angular';
import { addIcons } from 'ionicons';
import { arrowDown, search, filter, arrowBack } from 'ionicons/icons';

@Component({
  selector: 'app-estoque',
  templateUrl: './estoque.page.html',
  styleUrls: ['./estoque.page.scss'],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
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
    IonInput,
    IonCard
  ],
})
export class EstoquePage implements OnInit {
  constructor() {
    addIcons({ arrowDown, search, filter, arrowBack });
  }

  ngOnInit() {}
}
