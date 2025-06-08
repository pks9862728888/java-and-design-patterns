package src.main.java.bkp.java8.funcinterface.consumer;

import java.util.function.Consumer;

public class ConsumerTest {

  public static void main(String[] args) {
    // Implemented consumer which take a string and converts it into upper case
    Consumer<String> stringConsumer = no -> System.out.println(no.toUpperCase());
    stringConsumer.accept("hello consumer");

    // Implemented consumer which take a number and print 2 x the number
    Consumer<Integer> intConsumer = no -> System.out.println(2 * no);
    intConsumer.accept(2);

    // Consumer chaining
    Consumer<Integer> chainedConsumer = no -> print2xNumber(no);
    chainedConsumer = chainedConsumer.andThen(no -> printNo(no));
    chainedConsumer.accept(3);

    // Consumer chaining (single line)
    Consumer<Integer> chainedConsumer1 =
        ((Consumer<Integer>) no -> print2xNumber(no))
        .andThen(no -> printNo(no));
    chainedConsumer1.accept(3);
  }

  private static void printNo(Integer no) {
    System.out.println(no);
  }

  private static void print2xNumber(Integer val) {
    System.out.println(2 * val);
  }
}
