import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { User } from '../_models/user';

@Injectable()
export class UserService {
  private _appDetailsUrl = environment._registerUserUrl;
  constructor(private http: HttpClient) { }



  register(user: User) {
    return this.http.post(this._appDetailsUrl, user);
  }
}