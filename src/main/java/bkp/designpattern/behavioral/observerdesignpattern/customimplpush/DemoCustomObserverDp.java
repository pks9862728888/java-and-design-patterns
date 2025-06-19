package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.WeatherData;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observable.AbstractObservable;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observable.WeatherDataObservable;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observers.AvgConditionsDisplayObserver;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observers.CurrConditionsDisplayObserver;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observable.WeatherObservable;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observers.AverageWeatherConditionDisplayObserver;
import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.javaimplpullstrategy.observers.CurrentConditionDisplayObserver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoCustomObserverDp {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    WeatherDataObservable weatherObservable = new WeatherDataObservable();
    weatherObservable.addObserver(new CurrConditionsDisplayObserver());
    weatherObservable.addObserver(new AvgConditionsDisplayObserver());

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

  private static void setWeatherData(WeatherDataObservable weatherObservable, int measurement) {
    weatherObservable.setWeatherData(new WeatherData(measurement, measurement, measurement));
  }
}
