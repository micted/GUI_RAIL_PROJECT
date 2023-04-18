package gui_railway_project.Stuffx;

import gui_railway_project.Stuff.Stuff;

public class Car extends Stuff{
    private String name;
    private int price;

    public Car(double weight, String name, int price) {
        super(weight);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }


}
