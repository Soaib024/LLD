package DesignPattern.BehavioralDesignPattern.ObserverPattern.Observer;

import DesignPattern.BehavioralDesignPattern.ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserver implements NotificationAlertObserver{

    String phoneNumber;
    StocksObservable observable;
    
    public MobileAlertObserver(String phoneNumber, StocksObservable observable) {
    	this.phoneNumber = phoneNumber;
    	this.observable = observable;
    }
    
    
    @Override
    public void update() {
        this.sendEmail();
    }

    private void sendEmail(){
        System.out.println("SMS sent to: " + phoneNumber);
        // Actual logic
    }

}
