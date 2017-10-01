import { Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { ShopComponent } from './shop/shop.component';
import { CartComponent } from './cart/cart.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoComponent} from './todo/todo.component';


export const ROUTES: Routes = [
    {
        path: '', component: LayoutComponent,
        children: [
            { path: '', component: ShopComponent },
            { path: 'shop', component: ShopComponent },
            { path: 'cart', component: CartComponent },
        ],
    },
    { path: ':status', component: TodoComponent },
    { path: '**', redirectTo: '/all' }

];
