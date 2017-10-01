import { ActionReducer, Action, createSelector, createFeatureSelector } from '@ngrx/store';
import { State } from '../store/main-state';
import { TodoItem11 } from '../models/todoitem';

export interface ITodoAction {
  type: string;
  text?: string;
  itemId?: string;
  completed?: boolean;
}

export const mainStoreReducer =
  (state = [], action: ITodoAction) => {
    console.log('Action came in! ' + action.type);
    switch (action.type) {
      case 'ADD': {
        console.log('Action came in! ' + action.text);
        return {
          data: state.push(new TodoItem11(action.text))
        };
      }
      case 'SELECT': {
        return {
          // data: state.filter((i: TodoItem11) => i.uuid !== action.itemId)
        };
      }
      default: {
        return state;
      }
    }
  };
