package main.lesson1.umldiagram.beans.device;

import main.lesson1.umldiagram.beans.accomodation.Apartment;
import main.lesson1.umldiagram.interfaces.Switchable;

import java.awt.*;

public abstract class AbstractDevice implements Switchable {

    private Apartment apartment;
    private String producerName;
    private String modelName;
    private double price;
    private Color color;
    private double weight;

    public AbstractDevice(Apartment apartment,
                          String producerName,
                          String modelName,
                          double price,
                          Color color,
                          double weight) {
        this.apartment = apartment;
        this.producerName = producerName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.weight = weight;
    }

    public abstract String getDeviceTitle();

    public Apartment getApartment() {
        return apartment;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getModelName() {
        return modelName;
    }

    public double getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDevice)) return false;

        AbstractDevice that = (AbstractDevice) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (!apartment.equals(that.apartment)) return false;
        if (!producerName.equals(that.producerName)) return false;
        if (!modelName.equals(that.modelName)) return false;
        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = apartment.hashCode();
        result = 31 * result + producerName.hashCode();
        result = 31 * result + modelName.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Producer = '" + producerName + '\'' +
                ", Model = '" + modelName + '\'' +
                ", Price = " + price +
                ", Color = " + color +
                ", Weight = " + weight;
    }
}
