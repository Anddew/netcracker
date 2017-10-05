package main.lesson1.umldiagram.bean.accomodation;

import main.lesson1.umldiagram.bean.accomodation.tool.PowerController;
import main.lesson1.umldiagram.bean.device.AbstractDevice;
import main.lesson1.umldiagram.bean.device.ElectricalDevice;
import main.lesson1.umldiagram.enums.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class Apartment {

    private PowerController powerController = new PowerController();
    private List<AbstractDevice> deviceList = new ArrayList<>();

    public PowerController getPowerController() {
        return powerController;
    }

    public void addDevice(AbstractDevice device) {
        deviceList.add(device);
        if(device.getDeviceType() == DeviceType.ELECTRICAL_DEVICE) {
            ElectricalDevice electricalDevice = (ElectricalDevice) device;
            electricalDevice.assignPowerController(powerController);
        }
    }

    public void removeDevice(AbstractDevice device) {
        deviceList.remove(device);
    }

    public List<AbstractDevice> getDeviceList() {
        return deviceList;
    }

    public void switchOnDevices() {
        for(AbstractDevice device : deviceList) {
            if(device.hashCode() % 2 != 0) {
                device.switchOn();
                System.out.println(device.getDeviceTitle() + " was switched on.");
                if(device.getDeviceType() == DeviceType.ELECTRICAL_DEVICE) {
                    ElectricalDevice electricalDevice = (ElectricalDevice) device;
                    System.out.println("Power consumption = " + electricalDevice.getPowerConsumption() + " W.");
                }
            }
        }
    }

}
