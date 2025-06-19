package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observers;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observable.AbstractObservable;

public abstract class AbstractObserver<T> {

  public abstract void update(AbstractObservable<T> observable, T data);
}
