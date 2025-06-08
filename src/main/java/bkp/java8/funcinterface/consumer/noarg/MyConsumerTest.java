package src.main.java.bkp.java8.funcinterface.consumer.noarg;

public class MyConsumerTest {

  public static void main(String[] args) {
    // Anonymous class used to create object
    // using functional interface directly inline without need of creating a separate class
    MyConsumer executor = new MyConsumer(){
      @Override
      public void accept() {
        System.out.println("No arg functional interface");
      }
    };
    executor.accept();
    executor.accept();

    // Replacing anonymous function with lambda expression
    MyConsumer lambdaExecutor = () -> System.out.println("Lambda executing");
    lambdaExecutor.accept();
    lambdaExecutor.accept();
  }
}
