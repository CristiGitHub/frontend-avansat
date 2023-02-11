import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NavbarComponent} from "./components/navbar/navbar.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MenuModule} from "primeng/menu";
import {TabMenuModule} from "primeng/tabmenu";
import {MenubarModule} from "primeng/menubar";
import {ClothingModalComponent} from "./components/clothing-modal/clothingModal.component";
import {SidebarModule} from "primeng/sidebar";
import {ButtonModule} from "primeng/button";
import {CardModule} from "primeng/card";
import {ColorPickerModule} from "primeng/colorpicker";
import {FormsModule} from "@angular/forms";
import {ClothingMainComponent} from "./components/clothing-main/clothing-main.component";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";
import {DropdownModule} from "primeng/dropdown";
import {KeycloakAuthGuard, KeycloakService} from "keycloak-angular";
import {AuthGuard} from "./guard/AuthGuard";
import {AdminDashboardComponent} from "./components/admin-dashboard/admin-dashboard.component";
import {AboutComponent} from "./components/about/about.component";


const routes: Routes = [
  { path: 'home', component: NavbarComponent },
  { path: 'clothes', component: ClothingMainComponent },
  { path: 'about', component:  AboutComponent},
  { path: 'clothing/:id' , component: ClothingModalComponent},
  { path: 'clothing' , component: ClothingModalComponent},
  { path: 'admin' , component: AdminDashboardComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    MenuModule,
    TabMenuModule,
    MenubarModule,
    BrowserAnimationsModule,
    SidebarModule,
    ButtonModule,
    CardModule,
    ColorPickerModule,
    FormsModule,
    InputTextModule,
    InputTextareaModule,
    DropdownModule
  ],
  declarations: [
    NavbarComponent,
    ClothingModalComponent
  ],
  exports: [RouterModule, NavbarComponent ,ClothingModalComponent]
})
export class AppRoutingModule { }


