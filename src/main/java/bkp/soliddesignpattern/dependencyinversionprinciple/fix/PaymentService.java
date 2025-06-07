package src.main.java.bkp.soliddesignpattern.dependencyinversionprinciple.fix;

import src.main.java.bkp.soliddesignpattern.dependencyinversionprinciple.providers.IPaymentProvider;

public class PaymentService {

  // Fix is to code to interface and not to implementation
  // Payment service doesn't have to know which payment provider is being used
  // It just needs to know that it is a payment provider
  // Let factory handle the construction of objects, and then pass to this method to make payment
  public boolean makePayment(double amount, IPaymentProvider paymentProvider) {
    return paymentProvider.makePayment(amount);
  }
}
