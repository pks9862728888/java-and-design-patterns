package src.main.java.bkp.java8.funcinterface;

import java.util.function.Function;

public class LambdaTest {

  public static void main(String[] args) {
    // effectively final variable, so we can access
    // effectively final means value is not getting changed after assignment by any operation
    int num = 10;
    // num += 1;  // this will not be allowed
    Function<Integer, Integer> function = n -> n * num;
    System.out.println(function.apply(3));
    // num += 1; // this is also not allowed since variable is getting modified in same method scope

    // final variables can also be accessed from method scope
    final int num2 = 10;
    Function<Integer, Integer> function2 = n -> n * num2;
    System.out.println(function2.apply(3));

    // In short: we can access variables from local scope provided the value does not get modified
  }
}
