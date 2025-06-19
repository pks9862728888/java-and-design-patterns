package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observable;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;

public class WeatherDataObservable extends AbstractObservable<WeatherData> {

  public synchronized void setWeatherData(WeatherData weatherData) {
    System.out.println("Source weather data: " + weatherData);
    setChanged();
    notifyObservers(weatherData); // push based
  }
}
