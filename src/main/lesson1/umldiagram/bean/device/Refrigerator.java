package main.lesson1.umldiagram.bean.device;

import main.lesson1.umldiagram.enums.RefrigeratorNoFrostType;

import java.awt.Color;

public class Refrigerator extends ElectricalDevice {

    private RefrigeratorNoFrostType noFrostType;
    private int noiseLevel;
    private boolean hasIceGenerator;

    private Refrigerator(Builder builder) {
        super(builder.producerName,
              builder.modelName,
              builder.price,
              builder.color,
              builder.weight,
              builder.consumedPower);
        this.noFrostType = builder.noFrostType;
        this.noiseLevel = builder.noiseLevel;
        this.hasIceGenerator = builder.hasIceGenerator;
    }

    public static class Builder {
        private String producerName;
        private String modelName;
        private double price;
        private Color color = new Color(0);;
        private double weight = 0;
        private int consumedPower;
        private RefrigeratorNoFrostType noFrostType;
        private int noiseLevel = 0;
        private boolean hasIceGenerator = false;

        public Builder(String producerName,
                       String modelName,
                       double price,
                       int consumedPower,
                       RefrigeratorNoFrostType noFrostType) {
            this.producerName = producerName;
            this.modelName = modelName;
            this.price = price;
            this.consumedPower = consumedPower;
            this.noFrostType = noFrostType;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder noiseLevel(int noiseLevel) {
            this.noiseLevel = noiseLevel;
            return this;
        }

        public Builder hasIceGenerator(boolean hasIceGenerator) {
            this.hasIceGenerator = hasIceGenerator;
            return this;
        }

        public Refrigerator build() {
            return new Refrigerator(this);
        }

    }

    public RefrigeratorNoFrostType getNoFrostType() {
        return noFrostType;
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public boolean hasIceGenerator() {
        return hasIceGenerator;
    }

    @Override
    public String getDeviceTitle() {
        return "Refrigerator";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Refrigerator)) return false;
        if (!super.equals(o)) return false;

        Refrigerator that = (Refrigerator) o;

        if (noiseLevel != that.noiseLevel) return false;
        if (hasIceGenerator != that.hasIceGenerator) return false;
        return noFrostType == that.noFrostType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + noFrostType.hashCode();
        result = 31 * result + noiseLevel;
        result = 31 * result + (hasIceGenerator ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator: " + super.toString() +
                ", NoFrost type = " + noFrostType +
                ", Noise level = " + noiseLevel +
                ", Ice generator = " + hasIceGenerator +
                ".";
    }
}
