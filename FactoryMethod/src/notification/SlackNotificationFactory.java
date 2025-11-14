package notification;

public class SlackNotificationFactory extends NotificationFactory{
    public Notification factoryMethod(){
        return new SlackNotification();
    }
}
