package notification;

public abstract class NotificationFactory{
    abstract public Notification factoryMethod();
    public Notification createNotification(){
        return factoryMethod();
    }
}
