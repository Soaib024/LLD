package virtualMachine;

import java.util.HashMap;
import java.util.Map;

interface VirtualMachinePrototype{
    VirtualMachinePrototype copy();
    void showDetails();
}
class VirtualMachine implements VirtualMachinePrototype{
    private String name;
    private String os;
    private int cpuCores;
    private int memoryGB;
    private Map<String, String> tags = new HashMap<>();

    public VirtualMachine(String name, String os, int cpuCores, int memoryGB){
        this.name = name;
        this.os = os;
        this.cpuCores = cpuCores;
        this.memoryGB = memoryGB;
    }

    public VirtualMachine(VirtualMachine src){
        this.name = src.name;
        this.os = src.os;
        this.cpuCores = src.cpuCores;
        this.memoryGB = src.memoryGB;
        this.tags = new HashMap<>();
    }

    public void addTag(String key, String value) {
        tags.put(key, value);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public void showDetails() {
        System.out.println("VM{name='" + name + "', os='" + os +
                "', cpu=" + cpuCores + ", memory=" + memoryGB +
                "GB, tags=" + tags + "}");
    }


    @Override
    public VirtualMachinePrototype copy() {
        return new VirtualMachine(this);
    }
}

class VMRegistry{
    private static final Map<String, VirtualMachine> prototypes = new HashMap<>();
    static {
        VirtualMachine ubuntuTemplate = new VirtualMachine("Ubuntu-Base", "Ubuntu 22.04", 4, 8);
        ubuntuTemplate.addTag("env", "base");
        prototypes.put("ubuntu", ubuntuTemplate);

        VirtualMachine windowsTemplate = new VirtualMachine("Windows-Base", "Windows Server 2022", 8, 16);
        windowsTemplate.addTag("env", "base");
        prototypes.put("windows", windowsTemplate);
    }

    public static VirtualMachine getPrototype(String type){
        VirtualMachine prototype = prototypes.get(type.toLowerCase());
        if (prototype == null) throw new IllegalArgumentException("Unknown VM type: " + type);
        return new VirtualMachine(prototype);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Using Copy Constructor Prototype ===");

        // Clone an Ubuntu VM from the registry
        VirtualMachine vm1 = VMRegistry.getPrototype("ubuntu");
        vm1.setName("soaib-ubuntu-01");
        vm1.addTag("owner", "Soaib");
        vm1.showDetails();

        // Clone another Ubuntu VM with slight modification
        VirtualMachine vm2 = VMRegistry.getPrototype("ubuntu");
        vm2.setName("soaib-ubuntu-02");
        vm2.setCpuCores(6);
        vm2.addTag("env", "dev");
        vm2.showDetails();

        // Clone a Windows VM
        VirtualMachine vm3 = VMRegistry.getPrototype("windows");
        vm3.setName("soaib-win-01");
        vm3.addTag("project", "PaaS-LB");
        vm3.showDetails();
    }
}
