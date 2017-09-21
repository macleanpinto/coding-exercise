import { PRODUCTS } from '../models/mock-inventory';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { environment } from '../../environments/environment';



@Injectable()
export class ProductService {

  private _fetchProducts = environment.fetchProducts;
  constructor(private _http: Http) { }


  public getProducts() {
    return this._http.get(this._fetchProducts)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    return Observable.throw(error.json().error || 'Server error');
  }
}
