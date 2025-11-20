import java.util.HashMap;
import java.util.Map;

class BillPughSingleton{
    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

class DoubleCheckingSingleton{
    private DoubleCheckingSingleton(){}
    private static volatile DoubleCheckingSingleton instance;

    public static DoubleCheckingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckingSingleton();
                }
            }
        }
        return instance;
    }
}

// Factory Method
interface Notification{
    public void send(String message);
}

class SMSNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotificationFactory{
//    public Notification createNotification(String type){
//        if (type == null){
//            return null;
//        }
//
//        if(type.equalsIgnoreCase("sms")){
//            return new SMSNotification();
//        }
//
//        if(type.equalsIgnoreCase("email")){
//            return new EmailNotification();
//        }
//
//        return null;
//    }

    protected abstract Notification helper();
    public Notification createNotification(){
        return helper();
    }
}

class SMSNotificationFactory extends NotificationFactory{
    protected Notification helper(){
        return new SMSNotification();
    }
}

class EmailNotificationFactory extends NotificationFactory{
    protected Notification helper(){
        return new EmailNotification();
    }
}


// Abstract Factory

interface LoginService{
    void authenticate(String user);
}

interface VPCService{
    void createVPC(String name, String region);
}

interface SubnetService{
    void createSubnet(String name, String cidr);
}

class IBMCloudLoginService implements LoginService{
    public void authenticate(String user){
        System.out.println("[IBM Cloud] Authenticating user: " + user);
    }
}

class IBMCloudVPCService implements VPCService{
    @Override
    public void createVPC(String name, String region) {
        System.out.println("[IBM Cloud] Creating VPC: " + name);
    }
}

class IBMCloudSubnetService implements SubnetService{
    @Override
    public void createSubnet(String name, String cidr) {
        System.out.println("[IBM Cloud] Creating Subnet: " + name + " with CIDR " + cidr);
    }
}

// AWS concrete Implementations
class AWSLoginService implements LoginService {
    @Override
    public void authenticate(String user) {
        System.out.println("[AWS] Logging in user: " + user);
    }
}

class AWSVPCService implements VPCService {
    @Override
    public void createVPC(String name, String region) {
        System.out.println("[AWS] Creating VPC: " + name);
    }
}

class AWSSubnetService implements SubnetService {
    @Override
    public void createSubnet(String name, String cidr) {
        System.out.println("[AWS] Creating Subnet: " + name + " with CIDR " + cidr);
    }
}

interface CloudFactory{
    public LoginService createLoginService();
    public VPCService createVPCService();
    public SubnetService createSubnetService();
}

class IBMCLoudFactory implements CloudFactory{
    public LoginService createLoginService(){return new IBMCloudLoginService();}
    public VPCService createVPCService(){return new IBMCloudVPCService();}
    public SubnetService createSubnetService(){return new IBMCloudSubnetService();}
}

class AWSCloudFactory implements CloudFactory{
    public LoginService createLoginService(){return new AWSLoginService();}
    public VPCService createVPCService(){return new AWSVPCService();}
    public SubnetService createSubnetService(){return new AWSSubnetService();}
}

// Builder
class HTTPRequest{
    private final String url;

    // Optional
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;
    private HTTPRequest(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }
    // Getters (optional)
    public String getUrl() { return url; }
    public String getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public Map<String, String> getQueryParams() { return queryParams; }
    public String getBody() { return body; }
    public int getTimeout() { return timeout; }

    public String toString(){
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", queryParams=" + queryParams +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    public static class Builder{
        private final String url;
        private String method = "GET";
        private final Map<String, String> headers = new HashMap<>();
        private final Map<String, String> queryParams = new HashMap<>();
        private String body;
        private int timeout = 30000;
        public Builder(String url){
            this.url = url;
        }

        public Builder method(String method){
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value){
            this.headers.put(key, value);
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            this.queryParams.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HTTPRequest build(){
            return new HTTPRequest(this);
        }
    }
}



public class Main{
    static void main(String[] args) {
//        NotificationFactory notificationFactory = new NotificationFactory();
//        Notification email = notificationFactory.createNotification("email");
//        Notification sms = notificationFactory.createNotification("sms");
//


        Notification email = new EmailNotificationFactory().createNotification();
        Notification sms = new SMSNotificationFactory().createNotification();
        email.send("Hi!");
        sms.send("Hello!");

        CloudFactory ibmCloud = new IBMCLoudFactory();
        ibmCloud.createLoginService().authenticate("Soaib");
        ibmCloud.createVPCService().createVPC("vpc-1", "us-south");
        ibmCloud.createSubnetService().createSubnet("subnet-1", "1.1.1.0/28");

        HTTPRequest request = new HTTPRequest.Builder("url").build();
    }
}
