package src.main.java.bkp.java8.funcinterface.predicate;

import java.util.function.Predicate;

public class PredicateTest {

  public static void main(String[] args) {
    // Predicate is used to test a condition
    Predicate<Integer> testEvenNo = no -> no % 2 == 0;
    System.out.println("is even 2: " + testEvenNo.test(2));
    System.out.println("is even 1: " + testEvenNo.test(1));

    // Chaining predicate (test if no is divisible by 5 and 10)
    // legacy way
    Predicate<Integer> testDivisibleBy5N10 = no -> no % 5 == 0 && no % 10 == 0;
    System.out.println("is divisible by 5 and 10: " + testDivisibleBy5N10.test(10));
    // with chaining (recommended - declarative coding, focus on what we do, rather than how we do)
    Predicate<Integer> testDivisibleBy5N10Chained = ((Predicate<Integer>) no -> divisibleBy5(no))
        .and(no -> divisibleBy10(no));
    System.out.println("is divisible by 5 and 10: " + testDivisibleBy5N10Chained.test(5));

    // test if a number is divisible by 5 or 10
    Predicate<Integer> testDivisibleBy5Or10Chained = ((Predicate<Integer>) no -> divisibleBy5(no))
        .or(no -> divisibleBy10(no));
    System.out.println("is divisible by 5 or 10: " + testDivisibleBy5Or10Chained.test(5));

    // test if a number is divisible is 5 and 10 and not 3
    Predicate<Integer> testDivisibleBy5And10AndNot3Chained = ((Predicate<Integer>) no -> divisibleBy5(no))
        .and(no -> divisibleBy10(no))
        .and(no -> !divisibleBy3(no));
    System.out.println("is divisible by 5 and 10 and not 3: " + testDivisibleBy5And10AndNot3Chained.test(10));

    // test if a number is divisible is 5 and 10 and not 3 (using negate)
    Predicate<Integer> testDivisibleBy5And10AndNot3Chained1 = ((Predicate<Integer>) no -> divisibleBy5(no))
        .and(no -> divisibleBy10(no))
        .and(((Predicate<Integer>) no -> divisibleBy3(no)).negate());
    System.out.println("is divisible by 5 and 10 and not 3: " + testDivisibleBy5And10AndNot3Chained1.test(10));
  }

  private static boolean divisibleBy3(Integer no) {
    return no % 3 == 0;
  }

  private static boolean divisibleBy10(Integer no) {
    return no % 10 == 0;
  }

  private static boolean divisibleBy5(Integer no) {
    return no % 5 == 0;
  }
}
