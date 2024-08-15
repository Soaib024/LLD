package DesignPattern.BehavioralDesignPattern.ObserverPattern.Observer;

import DesignPattern.BehavioralDesignPattern.ObserverPattern.Observable.StocksObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    String emailID;
    StocksObservable observable;
    
    public EmailAlertObserver(String emailID, StocksObservable observable) {
    	this.emailID = emailID;
    	this.observable = observable;
    }
    
    @Override
    public void update() {
        this.sendEmail();
    }

    private void sendEmail(){
        System.out.println("mail sent to: " + emailID);
        // Actual logic
    }
    

}
