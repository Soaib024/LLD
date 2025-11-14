package cloud;

interface LoginService{
    void authenticate(String user);
}

interface VPCService{
    void createVPC(String name);
}

interface SubnetService{
    void createSubnet(String name, String cidr);
}

// IBM Cloud concrete implementations
class IBMCloudLoginService implements LoginService{
    public void authenticate(String user){
        System.out.println("[IBM Cloud] Authenticating user: " + user);
    }
}

class IBMCloudVPCService implements VPCService{
    @Override
    public void createVPC(String name) {
        System.out.println("[IBM Cloud] Creating VPC: " + name);
    }
}

class IBMCloudSubentService implements SubnetService{
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
    public void createVPC(String name) {
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
    LoginService createLoginService();
    VPCService createVPCService();
    SubnetService createSubnetService();
}

class IBMCloudFactory implements CloudFactory{
    @Override
    public LoginService createLoginService() {
        return new IBMCloudLoginService();
    }

    @Override
    public VPCService createVPCService() {
        return new IBMCloudVPCService();
    }

    @Override
    public SubnetService createSubnetService() {
        return new IBMCloudSubentService();
    }
}

class AWSCloudFactory implements CloudFactory{

    @Override
    public LoginService createLoginService() {
        return new AWSLoginService();
    }

    @Override
    public VPCService createVPCService() {
        return new AWSVPCService();
    }

    @Override
    public SubnetService createSubnetService() {
        return new AWSSubnetService();
    }
}

class CloudFactoryProvider{
    public static CloudFactory getFactory(String provider){
        return switch (provider.toLowerCase()) {
            case "ibm" -> new IBMCloudFactory();
            case "aws" -> new AWSCloudFactory();
            default -> throw new IllegalArgumentException("Unknown cloud provider" + provider);
        };
    }
}



public class Main {
    static void main() {
        // System.out.println("=== IBM Cloud ===");
        CloudFactory ibm = CloudFactoryProvider.getFactory("ibm");
        LoginService ibmLoginService = ibm.createLoginService();
        VPCService ibmVPCService = ibm.createVPCService();
        SubnetService ibmSubnetService = ibm.createSubnetService();

        ibmLoginService.authenticate("Soaib");
        ibmVPCService.createVPC("soaib-ibm-vpc-01");
        ibmVPCService.createVPC("soaib-ibm-vpc-02");
        ibmSubnetService.createSubnet("soaib-ibm-subnet-01", "10.0.0.0/28");

        CloudFactory aws = CloudFactoryProvider.getFactory("aws");
        LoginService awsLoginService = aws.createLoginService();
        VPCService awsVPCService = aws.createVPCService();
        SubnetService awsSubnetService = aws.createSubnetService();

        // System.out.println("=== AWS Cloud ===");
        awsLoginService.authenticate("Soaib");
        awsVPCService.createVPC("soaib-vpc-aws-01");
        awsVPCService.createVPC("soaib-vpc-aws-02");
        awsSubnetService.createSubnet("soaib-subnet-aws-01", "172.16.0.0/28");
    }
}
