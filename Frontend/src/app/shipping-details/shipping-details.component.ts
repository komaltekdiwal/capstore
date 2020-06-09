import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shipping-details',
  templateUrl: './shipping-details.component.html',
  styleUrls: ['./shipping-details.component.css']
})
export class ShippingDetailsComponent implements OnInit {

  constructor(private router: Router) { }
  payment(){
    this.router.navigateByUrl('/bill');
  }
  ngOnInit(): void {
  }

}
