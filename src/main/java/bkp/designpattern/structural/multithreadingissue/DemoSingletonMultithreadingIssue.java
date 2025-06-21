package src.main.java.bkp.designpattern.structural.multithreadingissue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoSingletonMultithreadingIssue {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    executorService.execute(() -> getInstanceNPrint());
    executorService.execute(() -> getInstanceNPrint());
    executorService.execute(() -> getInstanceNPrint());
    executorService.execute(() -> getInstanceNPrint());
    executorService.execute(() -> getInstanceNPrint());
    executorService.shutdown();
  }

  public static void getInstanceNPrint() {
    SingletonClass singleton = SingletonClass.getInstance();
    System.out.println(singleton);
  }
}
