import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { TodoItem } from './../models/todoitem';
@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {

  editMode = false;
  @Input()
  item: TodoItem;

  @Output()
  done = new EventEmitter<string>();

  @Output()
  itemUpdated = new EventEmitter<TodoItem>();

  ngOnInit() {
  }

}
