package src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils;

public class LenovoLaptop implements Laptop {

  @Override
  public String getType() {
    return "Lenovo";
  }

  @Override
  public void performSomeTask() {
    System.out.println("Lenovo laptop task");
  }
}
