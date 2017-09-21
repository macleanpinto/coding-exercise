import { Component } from '@angular/core';
import { Product } from './../models/product';
import { CartEntity } from './../models/cart.entity';
import { ProductService } from './../services/product.service';
import { CartService } from './../services/cart.service';
import { OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from './../app.component';
import { Subscription } from 'rxjs/Subscription';
import { StatusCodes } from '../app.constants';
import { ToasterService, ToasterConfig } from 'angular2-toaster';

/**

* This component is responsible for the shop page. it displays the list of products and handles the filtering.
* All communication to local storage is made through the CartService
*
*/

@Component({
    selector: 'app-shop',
    templateUrl: './shop.component.html',
    styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

    @Input() public title: String;
    public selectedProduct: Product;
    public products: Product[];
    public visibleProducts: Product[];
    public product: Product;
    public filterVal = '';
    public subscription: Subscription[] = [];

    /**
    * Dependecy injection of the service with reflection by angular2
    */
    constructor(private _router: Router, private _toaster: ToasterService,
        private _productService: ProductService, private _cartService: CartService) {

        // this constructor is not empty, look at the params. creating and assigning private vars on one line, sweet.

        // body-less constructors in the future?

    }

    filter() {
        // filter out non maching products with js array.filter + string.includes
        this.visibleProducts = this.products.filter(product => product.description.toLowerCase().includes(this.filterVal.toLowerCase()));

    }

    /**
    * Selects a product. The product will be greyed due to the css applied to it.
    *
    **/
    onSelect(product: Product) {

        this.selectedProduct = product; // we will use this information to gray the selected node
    }

    /**
    * Append a product to the cart through the cartService ( that we got injected )
    * then navigate to the cart
    **/
    appendItem(product: Product) {

        // get the cart entry for the product
        this._cartService.getCartEntryByProductId(product.id).then(function (cartEntry: CartEntity) {

            // if product quantity hasnt been exeeded
            if (this.checkIfCapacityIsExeeded(cartEntry)) {

                this._cartService.addProductToCart(product);

                this._router.navigate(['/cart']);

            } else {
                // TODO: change this one to a modal later on, if needed
                this._toaster.pop('error', 'Out of stock for the given product.'
                    + ' You currently have ' + cartEntry.quantity
                    + ' of given product in your cart, while we in stock have ' + cartEntry.product.stockQuantity);

            }

        }.bind(this));

    }

    checkIfCapacityIsExeeded(cartEntry: CartEntity): boolean {

        return cartEntry === undefined || (cartEntry.quantity + 1 <= cartEntry.product.stockQuantity);

    }


    /**
    * Retrives the list of products with an Promise. This is not really neaded. But its
    * good practice to not let the Component know how we fetch the information.
    *
    * The data might be fetched from an API, or local storage ( current impl )
    *
    */
    getProducts() {
        this.subscription.push(this._productService.getProducts().subscribe(result => {
            if (result.statusCd === StatusCodes.INTERNAL_ERROR) {
                this._toaster.pop('error', 'Status: ' + result.statusCd, result.msg);
            } else {
                this.products = result;
                this.visibleProducts = result;
            }
        }));

    }

    /**
    * Avoiding fetching data in the constructor makes our code more testable. The solution is to use
    * the onInit provided by angular.
    **/
    ngOnInit() {

        this.getProducts();

    }



}
