import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { addIcons } from 'ionicons';
import { bag, mail } from 'ionicons/icons'; 
import { IonButtons,
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
  IonLabel,
  IonRadioGroup,
  IonRadio, } from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
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
    IonLabel,
    IonRadioGroup,
    IonRadio
  ],
})
export class LoginPage implements OnInit {
  constructor() {
    addIcons({ bag, mail });
  }

  ngOnInit() {}
}
