package store;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    protected List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public abstract void notifyObservers();
}
