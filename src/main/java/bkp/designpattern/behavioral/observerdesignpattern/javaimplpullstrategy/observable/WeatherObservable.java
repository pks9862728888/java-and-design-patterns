package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable;

import java.util.Observable;

public class WeatherObservable extends Observable {
  private double temperature;
  private double humidity;
  private double pressure;

  // Synchronization solves serialization issue
  // But currently its calls update() method of observers synchronously
  // So in case multiple observers are there, this slows down the system
  // Also if one of the observer throws exception the whole system will crash,
  // and other obs will not be notified
  public synchronized void setWeatherData(double temperature, double humidity, double pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public synchronized void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  public double getTemperature() {
    return temperature;
  }

  public double getHumidity() {
    return humidity;
  }

  public double getPressure() {
    return pressure;
  }
}
