package src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils;

public class DellLaptop implements Laptop {

  @Override
  public String getType() {
    return "Dell";
  }

  @Override
  public void performSomeTask() {
    System.out.println("Dell laptop task");
  }
}
