import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, PreloadAllModules } from '@angular/router';
import { ROUTES } from './app.routes';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { SumPipe } from './pipes/sum.pipe';
import { CartService } from './services/cart.service';
import { ProductService } from './services/product.service';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, Http } from '@angular/http';
import { ToasterModule, ToasterService } from 'angular2-toaster';
import { ShopComponent } from './shop/shop.component';
import { CartComponent } from './cart/cart.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoItemComponent } from './todo-item/todo-item.component';
import { TodoComponent } from './todo/todo.component';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { TodoService } from './services/todo.service';
import { StoreModule } from '@ngrx/store';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    ShopComponent,
    CartComponent,
    SumPipe,
    TodoListComponent,
    TodoItemComponent,
    TodoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ROUTES, { useHash: true, preloadingStrategy: PreloadAllModules }),
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ToasterModule
  ],
  providers: [CartService, ProductService, SumPipe, ToasterService, TodoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
