package src.main.java.bkp.java8.funcinterface.consumer.witharg;

class MyConsumerTest {

  public static void main(String[] args) {
    // Anonymous class used to create object
    // using functional interface directly inline without need of creating a separate class
    MyConsumer executor = new MyConsumer(){
      @Override
      public void accept(int no) {
        System.out.println("Number in anonymous class is: " + no);
      }
    };
    executor.accept(5);
    executor.accept(6);

    // Replacing anonymous function with lambda expression
    MyConsumer lambdaExecutor = (int no) -> System.out.println("Number in lambda is: " + no);
    lambdaExecutor.accept(5);
    lambdaExecutor.accept(6);

    // you don't have to specify data type or bracket also in lambda if only 1 parameter is present
    // Java will predict the data type from functional interface
    MyConsumer lambdaExecutor2 = no -> System.out.println("Number in lambda is: " + no);
    lambdaExecutor2.accept(5);
    lambdaExecutor2.accept(6);
  }
}
