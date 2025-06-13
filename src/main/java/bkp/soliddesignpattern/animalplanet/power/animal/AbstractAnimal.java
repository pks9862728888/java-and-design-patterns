package src.main.java.bkp.soliddesignpattern.animalplanet.power.animal;

public abstract class AbstractAnimal {

  private final String name;
  private int age;

  AbstractAnimal(String name, int age) {
    this.name = name;
    if (age >= 0) {
      this.age = age;
    } else {
      throw new IllegalArgumentException("Age must be >= 0");
    }
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
