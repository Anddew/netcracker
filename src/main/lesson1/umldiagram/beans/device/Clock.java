package main.lesson1.umldiagram.beans.device;

import main.lesson1.umldiagram.beans.accomodation.Apartment;

import java.awt.*;

public class Clock extends AbstractDevice {

    private static String title = "Clock";
    private boolean hasLEDDisplay;
    private boolean hasRadio;
    private boolean isSwitchOn;

    private Clock(Builder builder) {
        super(builder.apartment,
              builder.producerName,
              builder.modelName,
              builder.price,
              builder.color,
              builder.weight);
        this.hasLEDDisplay = builder.hasLEDDisplay;
        this.hasRadio = builder.hasRadio;
    }

    public static class Builder {
        private Apartment apartment;
        private String producerName;
        private String modelName;
        private double price;
        private Color color = new Color(0);
        private double weight = 0;
        private boolean hasLEDDisplay = false;
        private boolean hasRadio = false;

        public Builder(Apartment apartment,
                       String producerName,
                       String modelName,
                       double price) {
            this.apartment = apartment;
            this.producerName = producerName;
            this.modelName = modelName;
            this.price = price;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder hasLEDDisplay(boolean hasLEDDisplay) {
            this.hasLEDDisplay = hasLEDDisplay;
            return this;
        }

        public Builder hasRadio(boolean hasRadio) {
            this.hasRadio = hasRadio;
            return this;
        }

        public Clock build() {
            return new Clock(this);
        }

    }

    public boolean hasLEDDisplay() {
        return hasLEDDisplay;
    }

    public boolean hasRadio() {
        return hasRadio;
    }

    public boolean isSwitchOn() {
        return isSwitchOn;
    }

    @Override
    public void switchOn() {
        isSwitchOn = true;
    }

    @Override
    public void switchOff() {
        isSwitchOn = false;
    }

    @Override
    public String getDeviceTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clock)) return false;
        if (!super.equals(o)) return false;

        Clock clock = (Clock) o;

        if (hasLEDDisplay != clock.hasLEDDisplay) return false;
        if (hasRadio != clock.hasRadio) return false;
        return isSwitchOn == clock.isSwitchOn;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hasLEDDisplay ? 1 : 0);
        result = 31 * result + (hasRadio ? 1 : 0);
        result = 31 * result + (isSwitchOn ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clock: " + super.toString() +
                ", LED display = " + hasLEDDisplay +
                ", Radio = " + hasRadio +
                ".";
    }
}
