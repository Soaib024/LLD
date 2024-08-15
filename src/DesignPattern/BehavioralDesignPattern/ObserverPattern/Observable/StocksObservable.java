package DesignPattern.BehavioralDesignPattern.ObserverPattern.Observable;

import DesignPattern.BehavioralDesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

public interface  StocksObservable {
    public boolean register(NotificationAlertObserver observer);
    public boolean remove(NotificationAlertObserver observer);
    public void notifyObserver();
    public boolean setStock(int stock);
    public int getStock();
}
