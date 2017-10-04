package main.lesson1.umldiagram.beans.accomodation;

import main.lesson1.umldiagram.beans.accomodation.tool.PowerController;
import main.lesson1.umldiagram.beans.device.AbstractDevice;

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
    }

    public void removeDevice(AbstractDevice device) {
        deviceList.remove(device);
    }

    public List<AbstractDevice> getDeviceList() {
        return deviceList;
    }



}
