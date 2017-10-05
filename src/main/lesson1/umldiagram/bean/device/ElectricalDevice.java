package main.lesson1.umldiagram.bean.device;

import main.lesson1.umldiagram.bean.accomodation.tool.PowerController;
import main.lesson1.umldiagram.enums.DeviceType;

import java.awt.*;

public abstract class ElectricalDevice extends AbstractDevice {

    private PowerController assignedPowerController;
    private int powerConsumption;
    private boolean isSwitchedOn;

    public ElectricalDevice(String producerName,
                            String modelName,
                            double price,
                            Color color,
                            double weight,
                            int powerConsumption
    ) {
        super(producerName, modelName, price, color, weight);
        this.powerConsumption = powerConsumption;
    }

    public DeviceType getDeviceType() {
        return DeviceType.ELECTRICAL_DEVICE;
    }

    public PowerController getAssignedPowerController() {
        return assignedPowerController;
    }

    public void assignPowerController(PowerController powerController) {
        this.assignedPowerController = powerController;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    @Override
    public final void switchOn() {
        isSwitchedOn = true;
        assignedPowerController.increasePowerConsumption(powerConsumption);
    }

    @Override
    public final void switchOff() {
        isSwitchedOn = false;
        assignedPowerController.decreasePowerConsumption(powerConsumption);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricalDevice)) return false;
        if (!super.equals(o)) return false;

        ElectricalDevice that = (ElectricalDevice) o;

        if (powerConsumption != that.powerConsumption) return false;
        return isSwitchedOn == that.isSwitchedOn;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + powerConsumption;
        result = 31 * result + (isSwitchedOn ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
        ", Power consumption = " + powerConsumption;
    }
}
