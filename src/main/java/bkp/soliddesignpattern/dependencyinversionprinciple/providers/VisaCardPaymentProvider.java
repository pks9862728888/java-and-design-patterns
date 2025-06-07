package src.main.java.bkp.soliddesignpattern.dependencyinversionprinciple.providers;

public class VisaCardPaymentProvider implements IPaymentProvider {
  @Override
  public boolean makePayment(double amount) {
    System.out.println("Making payment of " + amount + " via Visa Card");
    return true;
  }
}
