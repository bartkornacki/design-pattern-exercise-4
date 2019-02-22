package model;

import java.util.ArrayList;
import java.util.List;

public interface Notifier {

    void registerObserver(Observer observer);

    void unregisteredObserver(Observer observer);

    void notifiedObservers();

}
