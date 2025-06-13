package src.main.java.bkp.soliddesignpattern.animalplanet;

import src.main.java.bkp.soliddesignpattern.animalplanet.power.animal.AbstractBird;
import src.main.java.bkp.soliddesignpattern.animalplanet.power.animal.birds.Pegion;

public class DemoAnimalPlanetGame {

  public static void main(String[] args) {
    AbstractBird bird = new Pegion("GreenPigeon");
    System.out.println("Age: " + bird.getAge());
    bird.executePower();
    System.out.println();

    // Now lets say after sometime by some business logic in game
    // birds age increases,
    // and along with that we want to provide new power if age is > 1
    bird.setAge(2);
    System.out.println("Age: " + bird.getAge());
    bird.executePower();
  }
}
