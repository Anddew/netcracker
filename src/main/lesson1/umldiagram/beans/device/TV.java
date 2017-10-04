package main.lesson1.umldiagram.beans.device;

import main.lesson1.umldiagram.beans.accomodation.Apartment;

import java.awt.*;

public class TV extends ElectricalDevice {

    private static String title = "TV";
    private int screenSize;
    private boolean has3D;

    private TV(Builder builder) {
        super(builder.apartment,
              builder.producerName,
              builder.modelName,
              builder.price,
              builder.color,
              builder.weight,
              builder.consumedPower);
        this.screenSize = builder.screenSize;
        this.has3D = builder.has3D;
    }

    public static class Builder {
        private Apartment apartment;
        private String producerName;
        private String modelName;
        private double price;
        private Color color = new Color(0);;
        private double weight = 0;
        private int consumedPower;
        private int screenSize = 0;
        private boolean has3D = false;

        public Builder(Apartment apartment,
                       String producerName,
                       String modelName,
                       double price,
                       int consumedPower) {
            this.apartment = apartment;
            this.producerName = producerName;
            this.modelName = modelName;
            this.price = price;
            this.consumedPower = consumedPower;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder screenSize(int screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder has3D(boolean has3D) {
            this.has3D = has3D;
            return this;
        }

        public TV build() {
            return new TV(this);
        }

    }

    public int getScreenSize() {
        return screenSize;
    }

    public boolean isHas3D() {
        return has3D;
    }

    @Override
    public String getDeviceTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TV)) return false;
        if (!super.equals(o)) return false;

        TV tv = (TV) o;

        if (screenSize != tv.screenSize) return false;
        return has3D == tv.has3D;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + screenSize;
        result = 31 * result + (has3D ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TV: " + super.toString() +
                ", Screen size = " + screenSize +
                ", 3D = " + has3D +
                ".";
    }
}
