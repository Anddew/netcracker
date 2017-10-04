package main.lesson1.umldiagram.beans.accomodation.tool;

public class PowerController {

    private int actualPowerConsumption;

    public int getActualPowerConsumption() {
        return actualPowerConsumption;
    }

    public void increasePowerConsumption(int powerConsumption) {
        actualPowerConsumption += powerConsumption;
    }

    public void decreasePowerConsumption(int powerConsumption) {
        actualPowerConsumption -= powerConsumption;
    }

}
