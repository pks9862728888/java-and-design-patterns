package src.main.java.bkp.java8.funcinterface.predicate;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class SpecializedPredicateTest {

  public static void main(String[] args) {

    // Predicate is used to test a condition
    Predicate<Integer> testEvenNo = no -> no % 2 == 0;
    System.out.println("is even 2: " + testEvenNo.test(2));
    System.out.println("is even 1: " + testEvenNo.test(1));

    // Specialized predicate, IntPredicate
    IntPredicate testEvenNo1 = no -> no % 2 == 0;
    System.out.println("is even 2: " + testEvenNo1.test(2));
    System.out.println("is even 1: " + testEvenNo1.test(1));

    // Specialized predicate, LongPredicate
    LongPredicate testEvenNo2 = no -> no % 2 == 0;
    System.out.println("is even 2: " + testEvenNo2.test(2));
    System.out.println("is even 1: " + testEvenNo2.test(1));

    // Specialized predicate, BiPredicate (takes two input no and then compares)
    BiPredicate<Integer, Integer> testFirstNoIsGreater = (no1, no2) -> no1 > no2;
    System.out.println("is 2 > 5: " + testFirstNoIsGreater.test(2, 5));
    System.out.println("is 1 > 0: " + testFirstNoIsGreater.test(1, 0));
  }
}
