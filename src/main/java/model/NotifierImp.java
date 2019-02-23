package model;

import java.util.ArrayList;
import java.util.List;

public class NotifierImp implements Notifier {
    List<Observer>  observers;

    public NotifierImp(){
        this.observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisteredObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }
}