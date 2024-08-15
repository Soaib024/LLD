package DesignPattern.BehavioralDesignPattern.ObserverPattern.Observable;
import java.util.HashSet;
import java.util.Set;

import DesignPattern.BehavioralDesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

public class IphoneObservable implements StocksObservable{
	
	Set<NotificationAlertObserver> observers = new HashSet<>();
	int stock = 0;

	@Override
	public boolean register(NotificationAlertObserver observer) {
		return observers.add(observer);
	}

	@Override
	public boolean remove(NotificationAlertObserver observer) {
		return observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(NotificationAlertObserver observer: observers) {
			observer.update();
		}
		
	}

	@Override
	public boolean setStock(int stock) {
		if(stock < 0) {
			return false;
		}
		this.stock = stock;
		notifyObserver();
		return true;
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return this.stock;
	}

}
