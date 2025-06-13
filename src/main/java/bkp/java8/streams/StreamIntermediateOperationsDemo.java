package src.main.java.bkp.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamIntermediateOperationsDemo {

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    filteringDemo(integers);
    mapDemo(integers);
    flatMapDemo();
    skipDemo(integers);
    limitDemo(integers);
    skipNLimitDemo(integers);
    distinctDemo();
    sortedDemo();
  }

  private static void filteringDemo(List<Integer> integers) {
    System.out.println("filtering (print only even integers) -------------------------");
    integers.stream()
        .filter(i -> i % 2 == 0) // Predicate -> returns true if integer is even
        .forEach(System.out::println); // only even integers are printed here
  }

  private static void mapDemo(List<Integer> integers) {
    // Map is used when you want to call a function on each element
    // and do something else on the output
    System.out.println("map-------------------------");
    integers.stream()
        .map(i -> i * 2.0) // Function -> returns a new value after some operation
        .forEach(System.out::println);
  }

  private static void flatMapDemo() {
    System.out.println("flatMap-------------------------");
    List<List<Integer>> listList = new ArrayList<>();
    listList.add(Arrays.asList(1, 2));
    listList.add(Arrays.asList(3, 4));
    System.out.println(listList);

    // print all elements of listList
    listList.stream()
        .peek(System.out::println)
        .flatMap(list -> list.stream()) // flattens the list List<T> to Stream<T>
        .forEach(System.out::println);
  }

  private static void skipDemo(List<Integer> integers) {
    System.out.println("skip first 2 numbers-------------------------");
    System.out.println(integers);
    integers.stream()
        .skip(2)
        .forEach(System.out::println);
  }

  private static void limitDemo(List<Integer> integers) {
    System.out.println("limit first 2 numbers-------------------------");
    System.out.println(integers);
    integers.stream()
        .limit(2)
        .forEach(System.out::println);
  }

  private static void skipNLimitDemo(List<Integer> integers) {
    System.out.println("print only third and fourth number-------------------------");
    System.out.println(integers);
    integers.stream()
        .skip(2)
        .limit(2)
        .forEach(System.out::println);
  }

  private static void distinctDemo() {
    System.out.println("distinct-------------------------");
    List<Integer> integers = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2));
    System.out.println(integers);
    integers.stream()
        .distinct()
        .forEach(System.out::println);
  }

  private static void sortedDemo() {
    System.out.println("sorted-------------------------");
    List<Integer> integers = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 2));
    System.out.println(integers);
    integers.stream()
        .sorted()
        .forEach(System.out::println);
  }
}
