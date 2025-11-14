package notification;

class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

class SlackNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SLACK: " + message);
    }
}

/*
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

class SlackNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SLACK: " + message);
    }
}

abstract class NotificationFactory {
    protected abstract Notification factoryMethod();

    public Notification createNotification() {
        return factoryMethod();
    }
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    protected Notification factoryMethod() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    @Override
    protected Notification factoryMethod() {
        return new SMSNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    @Override
    protected Notification factoryMethod() {
        return new PushNotification();
    }
}

class SlackNotificationFactory extends NotificationFactory {
    @Override
    protected Notification factoryMethod() {
        return new SlackNotification();
    }
}

public class NotificationTest {
    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        NotificationFactory smsFactory = new SMSNotificationFactory();
        NotificationFactory pushFactory = new PushNotificationFactory();
        NotificationFactory slackFactory = new SlackNotificationFactory();

        emailFactory.createNotification().send("Email message");
        smsFactory.createNotification().send("SMS message");
        pushFactory.createNotification().send("Push message");
        slackFactory.createNotification().send("Slack message");
    }
}
 */

