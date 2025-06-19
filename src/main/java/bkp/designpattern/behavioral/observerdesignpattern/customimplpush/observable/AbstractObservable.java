package src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observable;

import src.main.java.bkp.designpattern.behavioral.observerdesignpattern.customimplpush.observers.AbstractObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractObservable<T> {
  private List<AbstractObserver<T>> observers = Collections.synchronizedList(new ArrayList<>());
  // Changed flag allows observable to choose when to notify the observers
  // When a lot of write happens, sometimes we want only when values vary by certain threshold
  // then only we should notify observers
  protected volatile boolean changed = false;

  public synchronized void addObserver(AbstractObserver<T> observer) {
    if (observer == null) {
      throw new NullPointerException();
    }
    observers.add(observer);
  }

  public synchronized void deleteObserver(AbstractObserver<T> observer) {
    observers.remove(observer);
  }

  protected synchronized void setChanged() {
    this.changed = true;
  }

  protected synchronized void clearChanged() {
    this.changed = false;
  }

  protected void notifyObservers() {
    notifyObservers(null);
  }

  protected void notifyObservers(T data) {
    final List<AbstractObserver<T>> currObservers;
    // Create a local copy of all observers in synchronized manner
    synchronized (this) {
      if (!changed) {
        return;
      }
      currObservers = new ArrayList<>(observers);
      clearChanged();
    }
    // Observers can be notified without synchronization
    for (AbstractObserver<T> observer : currObservers) {
      try {
        observer.update(this, data);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
