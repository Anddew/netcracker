package main.lesson1.umldiagram;

import main.lesson1.umldiagram.beans.accomodation.Apartment;
import main.lesson1.umldiagram.beans.device.*;

import static main.lesson1.umldiagram.enums.RefrigeratorNoFrostType.*;

public class HomeDeviceRunner {

    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        addNewDevices(apartment);
        switchOn(apartment);
        checkPowerConsumption(apartment);
    }

    public static void addNewDevices(Apartment apartment) {
        apartment.addDevice(
                new TV.Builder(
                        apartment,
                        "Panasonic",
                        "TX50-4829",
                        1000,
                        350
                )
                        .screenSize(42)
                        .has3D(true)
                        .weight(13.2)
                        .build()
        );
        apartment.addDevice(
                new TV.Builder(
                        apartment,
                        "LG",
                        "TV55-0002",
                        730,
                        280
                )
                        .screenSize(55)
                        .build()
        );
        apartment.addDevice(
                new Refrigerator.Builder(
                        apartment,
                        "Whirlpool",
                        "WH-R-9288",
                        1288.5,
                        95,
                        FULL_NO_FROST
                )
                        .hasIceGenerator(true)
                        .build()
        );
        apartment.addDevice(
                new Clock.Builder(
                        apartment,
                        "Luch",
                        "Luch-201",
                        4.7
                )
                        .hasLEDDisplay(true)
                        .hasRadio(true)
                        .build()
        );
        System.out.println("Devices added:");
        apartment.getDeviceList().stream().forEach(System.out::println);
    }

    public static void switchOn(Apartment apartment) {
        for(AbstractDevice device : apartment.getDeviceList()) {
            if(device.hashCode() % 2 != 0) {
                device.switchOn();
                System.out.println(device.getDeviceTitle() + " was switched on.");
                if(device instanceof ElectricalDevice) {
                    ElectricalDevice electricalDevice = (ElectricalDevice) device;
                    System.out.println("Power consumption = " + electricalDevice.getPowerConsumption() + " W.");
                }
            }
        }
    }

    public static void checkPowerConsumption(Apartment apartment) {
        int actualPowerConsumption = apartment.getPowerController().getActualPowerConsumption();
        System.out.println("Actual power consumption is " + actualPowerConsumption + " W.");
    }

}
