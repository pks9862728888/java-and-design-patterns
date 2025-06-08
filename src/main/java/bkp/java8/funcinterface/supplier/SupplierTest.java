package src.main.java.bkp.java8.funcinterface.supplier;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SupplierTest {

  public static void main(String[] args) {
    // Supplier is used to return a value each time a method gets called
    Supplier<Integer> integerSupplier = () -> ThreadLocalRandom.current().nextInt();
    System.out.println(integerSupplier.get());
    System.out.println(integerSupplier.get());
  }
}
