package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable.javaimplpullstrategy.observers;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable.javaimplpullstrategy.observable.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

public class AverageWeatherConditionDisplayObserver implements Observer {

  public static final String SPACE = " ";

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WeatherObservable) {
      WeatherObservable weatherObservable = (WeatherObservable) o;
      System.out.println(getClass().getSimpleName() + SPACE +
          weatherObservable.getTemperature() + SPACE +
          weatherObservable.getPressure() + SPACE +
          weatherObservable.getHumidity());
    }
  }
}
