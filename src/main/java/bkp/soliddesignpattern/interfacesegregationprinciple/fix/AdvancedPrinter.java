package src.main.java.bkp.soliddesignpattern.interfacesegregationprinciple.fix;

public class AdvancedPrinter implements Printable, Scannable, Faxable {
  @Override
  public void print() {
    System.out.println("Printing");
  }
  @Override
  public void fax() {
    System.out.println("Sending fax");
  }
  @Override
  public void scan() {
    System.out.println("Scanning");
  }
}
