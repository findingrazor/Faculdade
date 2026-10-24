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
  IonLabel,
  IonSelect,
  IonSelectOption,
  IonCard,
} from '@ionic/angular';
import { addIcons } from 'ionicons';
import { arrowForward, arrowBack, pencilOutline, addCircle } from 'ionicons/icons';

@Component({
  selector: 'app-cadastroproduto',
  templateUrl: './cadastroproduto.page.html',
  styleUrls: ['./cadastroproduto.page.scss'],
  imports: [IonButtons,
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
    IonSelect,
    IonSelectOption,
    IonCard,]
})
export class CadastroprodutoPage implements OnInit {

  constructor() { 
    addIcons({ arrowForward, arrowBack, pencilOutline, addCircle });
  }

  ngOnInit() {
  }

}
