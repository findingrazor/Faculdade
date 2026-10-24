import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
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
} from '@ionic/angular';
import { addIcons } from 'ionicons';
import {
  arrowForward,
  checkmarkCircle,
  close,
  archive,
  cart,
  bagHandle,
  person,
  addCircle,
} from 'ionicons/icons';
import { MenuController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
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
  ],
})
export class HomePage {
  constructor(private menuCtrl: MenuController) {
    addIcons({
      arrowForward,
      checkmarkCircle,
      close,
      archive,
      cart,
      bagHandle,
      person,
      addCircle,
    });
  }

  fecharMenu() {
    this.menuCtrl.close('menu-principal');
  }
}
