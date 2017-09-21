import { Pipe, PipeTransform } from '@angular/core';
/*
*
*/
@Pipe({ name: 'sum' })
export class SumPipe implements PipeTransform {

  transform(value: number, args): any {

    const quantity = parseInt(args);
    return quantity * value;

  }
}


