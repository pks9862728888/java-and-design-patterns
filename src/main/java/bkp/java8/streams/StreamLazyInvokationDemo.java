package src.main.java.bkp.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLazyInvokationDemo {

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//    lazyInvokationDemo(integers);
    streamExecutionWithTerminalOperation(integers);
  }

  private static void lazyInvokationDemo(List<Integer> integers) {
    // To create a stream
    Stream<Integer> integerStream = integers.stream();

    // Stream is lazily initialized, so nothing gets printed here
    // Data will only get printed if terminal operation is called
    integerStream.peek(System.out::println);
  }

  private static void streamExecutionWithTerminalOperation(List<Integer> integers) {
    Stream<Integer> integerStream = integers.stream();
    integerStream.peek(System.out::println)
        .forEach(System.out::println); // for-each is a terminal operation
  }
}
