package main.lesson1.umldiagram;

import main.lesson1.umldiagram.bean.accomodation.Apartment;
import main.lesson1.umldiagram.bean.device.*;

import static main.lesson1.umldiagram.enums.RefrigeratorNoFrostType.*;

public class HomeDeviceRunner {

    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        addNewDevices(apartment);
        apartment.switchOnDevices();
        System.out.println("Actual power consumption is " +
                apartment.getPowerController().getActualPowerConsumption() +
                " W.");
    }

    public static void addNewDevices(Apartment apartment) {
        apartment.addDevice(
                new TV.Builder(
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
                        "Whirlpool",
                        "WH-R-9287",
                        1288.5,
                        95,
                        FULL_NO_FROST
                )
                        .hasIceGenerator(true)
                        .build()
        );
        apartment.addDevice(
                new Clock.Builder(
                        "Luch",
                        "Luch-205",
                        4.8
                )
                        .hasLEDDisplay(true)
                        .hasRadio(true)
                        .build()
        );
        System.out.println("Devices added:");
        apartment.getDeviceList().stream().forEach(System.out::println);
    }

}
