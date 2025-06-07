package src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils;

public class Macbook implements Laptop {

  @Override
  public String getType() {
    return "Macbook";
  }

  @Override
  public void performSomeTask() {
    System.out.println("Macbook task");
  }
}
