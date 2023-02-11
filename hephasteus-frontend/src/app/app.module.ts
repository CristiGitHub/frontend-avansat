import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { MenuModule } from 'primeng/menu';

import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {DataService} from "./service/data.service";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { ClothingMainComponent } from './components/clothing-main/clothing-main.component';
import {CardModule} from "primeng/card";
import {ToolbarModule} from "primeng/toolbar";
import {SplitButtonModule} from "primeng/splitbutton";
import { ClothingDisplayComponent } from './components/clothing-display/clothing-display.component';
import {ColorPickerModule} from "primeng/colorpicker";
import {FormsModule} from "@angular/forms";
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {TableModule} from "primeng/table";
import { AboutComponent } from './components/about/about.component';


function initializeKeycloak(keycloak: KeycloakService){
  return () =>
    keycloak.init({
      config:{
        url: 'http://localhost:8080/auth/',
        realm: 'demo',
        clientId: 'app-front'
      },
      initOptions:{
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
        window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
@NgModule({
  declarations: [
    AppComponent,
    ClothingMainComponent,
    ClothingDisplayComponent,
    AdminDashboardComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    ButtonModule,
    HttpClientModule,
    AppRoutingModule,
    KeycloakAngularModule,
    CardModule,
    ToolbarModule,
    SplitButtonModule,
    ColorPickerModule,
    FormsModule,
    DialogModule,
    InputTextModule,
    TableModule
  ],
  providers: [{
    provide: APP_INITIALIZER,
    useFactory: initializeKeycloak,
    multi: true,
    deps: [KeycloakService]
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
