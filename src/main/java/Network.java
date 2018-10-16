import java.util.*;

public class Network {
    private String name;
    private ArrayList<IConnect> devices;
    private int maxDevices;

    public Network(String name){
        this.devices = new ArrayList<>();
        this.name = name;
        this.maxDevices = 10;
    }

    public String getName(){
        return name;
    }

    public int getMaxDevices() {
        return maxDevices;
    }

    public int freeSlots() {
        return maxDevices - deviceCount();
    }

    public int deviceCount(){
        return devices.size();
    }

    public void connect(IConnect device){
        if (freeSlots() != 0) {
            device.connect(name);
            devices.add(device);
        }
    }

    public void disconnectAll(){
        devices.clear();
    }
}