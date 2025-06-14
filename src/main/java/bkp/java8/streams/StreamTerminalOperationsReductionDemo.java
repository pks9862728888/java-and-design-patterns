package src.main.java.bkp.java8.streams;

import java.util.Arrays;

public class StreamTerminalOperationsReductionDemo {

  public static void main(String[] args) {
    sumOfNumbersReduceDemo();
    averageDemo();
    printLargestDemo();
  }

  private static void sumOfNumbersReduceDemo() {
    System.out.println("sumOfNumbersReduceDemo------------------------");
    int[] numbers = {1, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(numbers));

    // using reduce method
    int sum = Arrays.stream(numbers)
        .reduce(0, (prevElement, currElement) -> prevElement + currElement);
    System.out.println(sum);

    // directly using sum method
    int sum1 = Arrays.stream(numbers)
        .sum();
    System.out.println(sum1);
  }

  private static void averageDemo() {
    System.out.println("averageDemo------------------------");
    int[] numbers = {10, 10, 10, 10, 10};
    System.out.println(Arrays.toString(numbers));
    double average = Arrays.stream(numbers)
        .average()
        .orElse(0.0);
    System.out.println(average);
  }

  private static void printLargestDemo() {
    System.out.println("printLargest------------------------");
    int[] numbers = {1, 2, 20, 3, 4, 5};
    System.out.println(Arrays.toString(numbers));

    // using reduce method
    int sum = Arrays.stream(numbers)
        .reduce(0, (prevElement, currElement) -> Math.max(prevElement, currElement));
    System.out.println(sum);
  }
}
