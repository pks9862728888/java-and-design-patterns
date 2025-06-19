package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observers;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observable.AbstractObservable;

public class CurrConditionsDisplayObserver extends AbstractObserver<WeatherData> {

  @Override
  public void update(AbstractObservable<WeatherData> observable, WeatherData data) {
    try {
      System.out.println(getClass().getSimpleName() + " " + data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
