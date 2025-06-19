package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy.observers;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy.WeatherData;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy.observable.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayObserver implements Observer {

  public static final String SPACE = " ";

  @Override
  public void update(Observable o, Object arg) {
    try {
      if (o instanceof WeatherObservable && arg instanceof WeatherData) {
        WeatherData weatherData = (WeatherData) arg;
        System.out.println(getClass().getSimpleName() + SPACE +
            weatherData.getTemperature() + SPACE +
            weatherData.getPressure() + SPACE +
            weatherData.getHumidity());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
