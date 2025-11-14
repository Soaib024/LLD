package notification;

public class EmailNotificationFactory extends NotificationFactory{
    @Override
    public Notification factoryMethod(){
        return new EmailNotification();
    }
}
