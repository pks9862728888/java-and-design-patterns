package src.main.java.bkp.soliddesignpattern.interfacesegregationprinciple.problem;

public class BasicPrinter implements Printer {
  @Override
  public void print() {
    System.out.println("Printing");
  }

  @Override
  public void scan() {
    throw new UnsupportedOperationException("Scanning is not supported!");
  }

  @Override
  public void fax() {
    throw new UnsupportedOperationException("Fax is not supported!");
  }
}
