package src.main.java.bkp.soliddesignpattern.interfacesegregationprinciple.problem;

public class AdvancedPrinter implements Printer {

  @Override
  public void print() {
    System.out.println("Printing");
  }

  @Override
  public void scan() {
    System.out.println("Scanning");
  }

  @Override
  public void fax() {
    System.out.println("Sending fax");
  }
}
