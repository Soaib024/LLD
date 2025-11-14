package notification;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification factoryMethod() {
        return new PushNotification();
    }
}
