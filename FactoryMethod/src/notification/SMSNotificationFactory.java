package notification;

public class SMSNotificationFactory extends NotificationFactory{
    @Override
    public Notification factoryMethod() {
        return new SMSNotification();
    }
}
