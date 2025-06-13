package src.main.java.bkp.soliddesignpattern.animalplanet.power.animal;

import src.main.java.bkp.soliddesignpattern.animalplanet.power.animal.powers.FlyableBirdPower;
import src.main.java.bkp.soliddesignpattern.animalplanet.power.animal.powers.IBirdPower;
import src.main.java.bkp.soliddesignpattern.animalplanet.power.animal.powers.NonFlyableBirdPower;

public class AbstractBird extends AbstractAnimal {

  // Strategy design pattern
  // Where you can change the behavior at run time
  private IBirdPower birdsPower;

  public AbstractBird(String name) {
    super(name, 0);
    birdsPower = new NonFlyableBirdPower();
  }

  public void setPower(IBirdPower birdsPower) {
    this.birdsPower = birdsPower;
  }

  public void executePower() {
    birdsPower.executePower();
  }

  @Override
  public void setAge(int age) {
    super.setAge(age);
    if (getAge() >= 1) {
      setPower(new FlyableBirdPower());
    }
  }
}
