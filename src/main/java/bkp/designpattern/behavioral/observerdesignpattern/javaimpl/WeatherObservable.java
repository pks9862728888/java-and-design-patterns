package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimpl;

import java.util.Observable;

public class WeatherObservable extends Observable {
  private double temperature;
  private double humidity;
  private double pressure;

  public void setWeatherData(double temperature, double humidity, double pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public void measurementsChanged() {
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
