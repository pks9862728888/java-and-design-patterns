package src.main.java.bkp.java8.funcinterface.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {

  public static void main(String[] args) {
    // Function which takes an argument and returns a value
    Function<Integer, Double> multiplicationFunc = no -> no * 2.0;
    System.out.println(multiplicationFunc.apply(2));

    // BiFunction which takes two arguments and returns a value (a - b)
    BiFunction<Integer, Integer, Integer> multiplicationFunc2 = (no1, no2) -> no1 - no2;
    System.out.println(multiplicationFunc2.apply(6, 4));

    // Chaining function (andThen executes 1st fn first and then 2nd)
    Function<Integer, Double> multiplicationFunc3 = ((Function<Integer, Double>) no -> no * 3.0)
        .andThen(no -> no * 4.0);
    System.out.println(multiplicationFunc3.apply(2));

    // Chaining function (compose executes 2nd fn first and then 1st)
    Function<Integer, Double> testCompose = ((Function<Double, Double>) no -> no * 3.0)
        .compose(no -> no * 4.0);
    System.out.println(testCompose.apply(2));
  }
}
