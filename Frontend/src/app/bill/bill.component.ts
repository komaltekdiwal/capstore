import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  constructor(private router: Router) { }
  cash(){
    this.router.navigateByUrl('/cash');
  }

  // tslint:disable-next-line: member-access
  cardPayment() {
    this.router.navigateByUrl('/card-payment');
  }
  ngOnInit(): void {
  }

}
