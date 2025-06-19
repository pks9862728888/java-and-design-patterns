package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable.WeatherObservable;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observers.AverageWeatherConditionDisplayObserver;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observers.CurrentConditionDisplayObserver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoObserverDesignPattern {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    WeatherObservable weatherObservable = new WeatherObservable();
    weatherObservable.addObserver(new CurrentConditionDisplayObserver());
    weatherObservable.addObserver(new AverageWeatherConditionDisplayObserver());

    // Issue: Observers can read stale data
    executorService.execute(() -> setWeatherData(weatherObservable, 10));
    executorService.execute(() -> setWeatherData(weatherObservable, 20));
    executorService.execute(() -> setWeatherData(weatherObservable, 30));
    executorService.execute(() -> setWeatherData(weatherObservable, 40));
    executorService.execute(() -> setWeatherData(weatherObservable, 50));
    executorService.execute(() -> setWeatherData(weatherObservable, 60));

//    setWeatherData(weatherObservable, 10);
//    setWeatherData(weatherObservable, 20);
//    setWeatherData(weatherObservable, 30);
//    setWeatherData(weatherObservable, 40);
//    setWeatherData(weatherObservable, 50);
    executorService.shutdown();
  }

  private static void setWeatherData(WeatherObservable weatherObservable, int measurement) {
    weatherObservable.setWeatherData(new WeatherData(measurement, measurement, measurement));
  }
}
