package src.main.java.bkp.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTerminalOperationsDemo {

  public static void main(String[] args) {
    collectDemo();
    maxMinDemo();
    findFirstDemo();
    findAnyDemo();
    allMatchDemo();
    noneMatchDemo();
    anyMatchDemo();
  }

  private static void collectDemo() {
    System.out.println("collect------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(numbers));
    // Collect to list
    List<Integer> evenNumbers = Arrays.stream(numbers)
        .filter(n -> n % 2 == 0)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(evenNumbers);

    // Collect to set
    Set<Integer> distinctEvenNumbers = Arrays.stream(numbers)
        .filter(n -> n % 2 == 0)
        .boxed()
        .collect(Collectors.toSet());
    System.out.println(distinctEvenNumbers);
  }

  private static void maxMinDemo() {
    System.out.println("maxMinDemo------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(numbers));
    // Max element
    Optional<Integer> max = Arrays.stream(numbers)
        .boxed()
        .max(Integer::compare);
    System.out.println(max);

    // Min element
    Optional<Integer> min = Arrays.stream(numbers)
        .boxed()
        .min(Integer::compare);
    System.out.println(min);
  }

  private static void findFirstDemo() {
    System.out.println("findFirst------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(numbers));
    Optional<Integer> first = Arrays.stream(numbers)
        .boxed()
        .findFirst();
    System.out.println(first);
  }

  private static void findAnyDemo() {
    System.out.println("findAnyDemo------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(numbers));
    Optional<Integer> first = Arrays.stream(numbers)
        .parallel()
        .boxed()
        .findAny();
    System.out.println(first);
  }

  private static void allMatchDemo() {
    System.out.println("allMatch------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(numbers));
    boolean allMatched = Arrays.stream(numbers)
        .allMatch(n -> n > 0);
    System.out.println(allMatched);
  }

  private static void noneMatchDemo() {
    System.out.println("noneMatch------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(numbers));
    boolean noneMatched = Arrays.stream(numbers)
        .noneMatch(n -> n > 0);
    System.out.println(noneMatched);
  }

  private static void anyMatchDemo() {
    System.out.println("anyMatch------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(numbers));
    boolean anyMatched = Arrays.stream(numbers)
        .anyMatch(n -> n == 3);
    System.out.println(anyMatched);
  }
}
