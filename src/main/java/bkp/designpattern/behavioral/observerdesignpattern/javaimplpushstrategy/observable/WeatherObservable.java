package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy.observable;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy.WeatherData;

import java.util.Observable;

public class WeatherObservable extends Observable {

  // Synchronization solves serialization issue
  // But currently its calls update() method of observers synchronously
  // So in case multiple observers are there, this slows down the system
  // Also if one of the observer throws exception the whole system will crash,
  // and other obs will not be notified
  public synchronized void setWeatherData(double temperature, double humidity, double pressure) {
    WeatherData currWeatherData = new WeatherData(temperature, humidity, pressure);
    System.out.println("Source data: " + temperature + " " + humidity + " " + pressure);
    measurementsChanged(currWeatherData);
  }

  public synchronized void measurementsChanged(WeatherData weatherData) {
    setChanged();
    notifyObservers(weatherData);
  }
}