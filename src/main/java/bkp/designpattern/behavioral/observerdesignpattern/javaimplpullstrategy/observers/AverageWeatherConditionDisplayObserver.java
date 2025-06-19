package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observers;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable.WeatherObservable;

import java.util.Observable;
import java.util.Observer;

public class AverageWeatherConditionDisplayObserver implements Observer {

  public static final String SPACE = " ";

  @Override
  public void update(Observable o, Object arg) {
    try {
      if (o instanceof WeatherObservable) {
        WeatherObservable weatherObservable = (WeatherObservable) o;
        WeatherData weatherData = weatherObservable.getWeatherData();
        System.out.println(getClass().getSimpleName() + SPACE + weatherData);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
