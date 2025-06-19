package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observers;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayObserver implements Observer {

  public static final String SPACE = " ";

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WeatherObservable) {
      WeatherObservable weatherObservable = (WeatherObservable) o;
      System.out.println(getClass().getSimpleName() + SPACE +
          weatherObservable.getTemperature() + SPACE +
          weatherObservable.getPressure() + SPACE +
          weatherObservable.getHumidity());
      throw new RuntimeException("Current condition observer crashed!");
    }
  }
}
