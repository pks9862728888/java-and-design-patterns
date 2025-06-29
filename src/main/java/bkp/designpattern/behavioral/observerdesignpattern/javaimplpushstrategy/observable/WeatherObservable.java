package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy.observable;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;

import java.util.Observable;

public class WeatherObservable extends Observable {

  // Synchronization solves serialization issue
  // But currently its calls update() method of observers synchronously
  // So in case multiple observers are there, this slows down the system
  // Also if one of the observer throws exception the whole system will crash,
  // and other obs will not be notified
  public synchronized void setWeatherData(WeatherData currWeatherData) {
    System.out.println("Source data: " + currWeatherData);
    measurementsChanged(currWeatherData);
  }

  public void measurementsChanged(WeatherData weatherData) {
    setChanged();
    notifyObservers(weatherData);
  }
}