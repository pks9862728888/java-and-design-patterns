package src.main.java.bkp.soliddesignpattern.interfacesegregationprinciple.fix;

public class BasicPrinter implements Printable {
  @Override
  public void print() {
    System.out.println("Printing");
  }
}
