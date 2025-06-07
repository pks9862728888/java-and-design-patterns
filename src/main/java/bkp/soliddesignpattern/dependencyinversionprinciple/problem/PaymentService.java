package src.main.java.bkp.soliddesignpattern.dependencyinversionprinciple.problem;

import src.main.java.bkp.soliddesignpattern.dependencyinversionprinciple.providers.UPIPaymentProvider;
import src.main.java.bkp.soliddesignpattern.dependencyinversionprinciple.providers.VisaCardPaymentProvider;

public class PaymentService {

  // Payment service is tightly coupled with concrete implementations
  VisaCardPaymentProvider paymentProvider = new VisaCardPaymentProvider();
  UPIPaymentProvider upiPaymentProvider = new UPIPaymentProvider();

  public boolean makePayment(double amount, String paymentMode) {
    if (paymentMode.equals("UPI")) {
      return upiPaymentProvider.makePayment(amount);
    } else if (paymentMode.equals("CARD")) {
      return paymentProvider.makePayment(amount);
    } else {
      return false;
    }
  }
}
