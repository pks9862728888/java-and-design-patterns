package src.main.java.bkp.java8.funcinterface.consumer.witharg;

// Annotating with FunctionalInterface ensures that there is only one abstract method in the interface
// But without this annotation, this interface is still a functional interface
@FunctionalInterface
interface MyConsumer {

  void accept(int no);

}
