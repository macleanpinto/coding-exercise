import { Component, OnInit } from '@angular/core';
import { TodoService } from '../services/todo.service';
import { Subscription } from 'rxjs/Subscription';
import { StatusCodes } from '../app.constants';
import { ToasterService, ToasterConfig } from 'angular2-toaster';
import { TodoItem11 } from '../models/todoitem';
import { TodoItem } from '../models/todoitem';
import { Store } from '@ngrx/store';
import { State, intitialState } from '../Store/main-state';
import { mainStoreReducer } from '../services/reducer';
@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  constructor(private _toaster: ToasterService, private todoService: TodoService, private store: Store<State>) {

    this.store.dispatch({ type: 'ADD', text: 'Task2', completed: true });
  }
  public subscription: Subscription[] = [];
  public items: TodoItem;
  public data: any;
  ngOnInit() {

   /* this.subscription.push(this.todoService.getItems().subscribe(result => {
      if (result.statusCd === StatusCodes.INTERNAL_ERROR) {
        this._toaster.pop('error', 'Status: ' + result.statusCd, result.msg);
      } else {
        this.items = result;
      }
    }));
*/
  }

}
