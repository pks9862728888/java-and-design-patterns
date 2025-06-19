package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;

import java.util.Observable;

public class WeatherObservable extends Observable {

  private volatile WeatherData weatherData;

  // Synchronization solves serialization issue
  // But currently its calls update() method of observers synchronously
  // So in case multiple observers are there, this slows down the system
  // Also if one of the observer throws exception the whole system will crash,
  // and other obs will not be notified
  public synchronized void setWeatherData(WeatherData weatherData) {
    System.out.println("Source weather data: " + weatherData);
    this.weatherData = weatherData;
    measurementsChanged();
  }

  public void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  public WeatherData getWeatherData() {
    return weatherData;
  }
}
