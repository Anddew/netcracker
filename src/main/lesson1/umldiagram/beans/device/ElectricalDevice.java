package main.lesson1.umldiagram.beans.device;

import main.lesson1.umldiagram.beans.accomodation.Apartment;

import java.awt.*;

public abstract class ElectricalDevice extends AbstractDevice {

    private int powerConsumption;
    private boolean isSwitchOn;

    public ElectricalDevice(Apartment apartment,
                            String producerName,
                            String modelName,
                            double price,
                            Color color,
                            double weight,
                            int powerConsumption
    ) {
        super(apartment, producerName, modelName, price, color, weight);
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public boolean isSwitchOn() {
        return isSwitchOn;
    }

    @Override
    public final void switchOn() {
        isSwitchOn = true;
        getApartment().getPowerController().increasePowerConsumption(powerConsumption);
    }

    @Override
    public final void switchOff() {
        isSwitchOn = false;
        getApartment().getPowerController().decreasePowerConsumption(powerConsumption);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricalDevice)) return false;
        if (!super.equals(o)) return false;

        ElectricalDevice that = (ElectricalDevice) o;

        if (powerConsumption != that.powerConsumption) return false;
        return isSwitchOn == that.isSwitchOn;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + powerConsumption;
        result = 31 * result + (isSwitchOn ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
        ", Power consumption = " + powerConsumption;
    }
}
