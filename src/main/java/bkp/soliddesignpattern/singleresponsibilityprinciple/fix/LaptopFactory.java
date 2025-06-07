package src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.fix;

import src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils.DellLaptop;
import src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils.Laptop;
import src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils.LenovoLaptop;
import src.main.java.bkp.soliddesignpattern.singleresponsibilityprinciple.utils.Macbook;

import java.util.ArrayList;
import java.util.List;

public class LaptopFactory {

  private static final List<Laptop> laptopList = new ArrayList<>();

  public LaptopFactory() {
    laptopList.add(new LenovoLaptop());
    laptopList.add(new DellLaptop());
    laptopList.add(new Macbook());
  }

  public static Laptop getLaptop(String laptopType) {
    for (Laptop l : laptopList) {
      if (l.getType().equals(laptopType)) {
        return l;
      }
    }
    throw new UnsupportedOperationException("No laptops found for type: " + laptopType);
  }
}
