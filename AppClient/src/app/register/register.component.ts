import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { UserService } from '../_services/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  data;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      socialSecNo: ['', [Validators.required, Validators.maxLength(9), Validators.minLength(9)]]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    this.data = '';

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }


    this.userService.register(this.registerForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.data = data;
        },
        error => {

          this.data = error;
        });
  }
}
