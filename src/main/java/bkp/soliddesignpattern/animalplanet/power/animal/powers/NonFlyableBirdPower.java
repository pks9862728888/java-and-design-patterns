package src.main.java.bkp.soliddesignpattern.animalplanet.power.animal.powers;

public class NonFlyableBirdPower implements IBirdPower {
  @Override
  public void executePower() {
    System.out.println("Sorry I can't fly");
  }
}
