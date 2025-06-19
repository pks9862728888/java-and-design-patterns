package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpushstrategy;

public class WeatherData {
  private double temperature;
  private double humidity;
  private double pressure;

  public WeatherData(double temperature, double humidity, double pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
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

  @Override
  public String toString() {
    return "WeatherData{" +
        "temperature=" + temperature +
        ", humidity=" + humidity +
        ", pressure=" + pressure +
        '}';
  }
}
