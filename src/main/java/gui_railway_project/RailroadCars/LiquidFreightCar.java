package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.BasicRailroadFreightCar;
import gui_railway_project.Stuff.Material;
import gui_railway_project.Stuff.Stuff;

public class LiquidFreightCar extends BasicRailroadFreightCar{
    public LiquidFreightCar(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        this.uniqueNum = "LFC" + uniqueNumGenerator;
    }

    @Override
    public void addCommodity(Stuff stuff) {
        if(((Material) stuff).getMaterial() == Stuff.Materials.liquidMaterial && currentCargoWeight + stuff.getWeight() < maxCargoWeight) {
            commodity.add(stuff);
            currentCargoWeight += stuff.getWeight();
        }
        else
            System.out.println(((Material) stuff).getMaterial() + "cannot be stored");
    }

}
