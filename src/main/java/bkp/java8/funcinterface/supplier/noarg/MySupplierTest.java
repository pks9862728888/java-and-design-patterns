package src.main.java.bkp.java8.funcinterface.supplier.noarg;

import java.util.concurrent.ThreadLocalRandom;

public class MySupplierTest {

  public static void main(String[] args) {
    // Anonymous class used to create object
    // using functional interface directly inline without need of creating a separate class
    MySupplier supplier = new MySupplier(){
      @Override
      public int get() {
        return ThreadLocalRandom.current().nextInt();
      }
    };
    System.out.println("Using anonymous function: " + supplier.get());
    System.out.println("Using anonymous function: " + supplier.get());

    // Replacing anonymous function with lambda expression
    MySupplier lambdaSupplier = () -> ThreadLocalRandom.current().nextInt();
    System.out.println("Using lambda: " + lambdaSupplier.get());
    System.out.println("Using lambda: " + lambdaSupplier.get());
  }
}
