package src.main.java.bkp.designpattern.structural.fix1eagerinstatiation;

import java.util.UUID;

public class SingletonClass {
  private final String uid;

  private static final SingletonClass instance = new SingletonClass();

  private SingletonClass() {
    this.uid = UUID.randomUUID().toString();
  }

  public static SingletonClass getInstance() {
    return instance;
  }

  @Override
  public String toString() {
    return "SingletonClass{" +
        "uid='" + uid + '\'' +
        '}';
  }
}
