import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BillComponent } from './bill/bill.component';
import { CardPaymentComponent } from './card-payment/card-payment.component';
import { CashComponent } from './cash/cash.component';
import { ShippingDetailsComponent } from './shipping-details/shipping-details.component';
import { ApplyCouponComponent } from './apply-coupon/apply-coupon.component';


const routes: Routes = [{ path: 'bill', component: BillComponent },
{ path: 'cash', component: CashComponent },
{ path: 'card-payment', component: CardPaymentComponent },
{ path: 'shipping-details', component: ShippingDetailsComponent },
{ path: 'apply-coupon', component: ApplyCouponComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
