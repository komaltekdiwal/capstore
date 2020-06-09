import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BillComponent } from './bill/bill.component';
import { CardPaymentComponent } from './card-payment/card-payment.component';
import { CashComponent } from './cash/cash.component';
import { ShippingDetailsComponent } from './shipping-details/shipping-details.component';
import { ApplyCouponComponent } from './apply-coupon/apply-coupon.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BillComponent,
    CardPaymentComponent,
    CashComponent,
    ShippingDetailsComponent,
    ApplyCouponComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
