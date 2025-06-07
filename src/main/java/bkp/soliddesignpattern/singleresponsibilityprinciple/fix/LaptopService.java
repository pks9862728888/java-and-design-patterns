package src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.fix;

import src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils.Laptop;

public class LaptopService {

  public void doSomething(String laptopType) {
    Laptop ob = LaptopFactory.getLaptop(laptopType);
    ob.performSomeTask();
  }
}

