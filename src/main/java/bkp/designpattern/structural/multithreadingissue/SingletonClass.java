package src.main.java.bkp.designpattern.structural.multithreadingissue;

import java.util.UUID;

public class SingletonClass {
  private final String uid;

  private static SingletonClass instance;

  private SingletonClass() {
    this.uid = UUID.randomUUID().toString();
  }

  public static SingletonClass getInstance() {
    if (instance == null) {
      instance = new SingletonClass();
    }
    return instance;
  }

  @Override
  public String toString() {
    return "SingletonClass{" +
        "uid='" + uid + '\'' +
        '}';
  }
}
