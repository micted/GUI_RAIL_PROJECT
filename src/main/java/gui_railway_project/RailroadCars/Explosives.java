package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.HeavyRailroadCar;
import gui_railway_project.Stuff.Material;
import gui_railway_project.Stuff.Stuff;

public class Explosives extends HeavyRailroadCar{
    public Explosives(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        this.uniqueNum = "EFC" + uniqueNumGenerator;
    }

    public void addCommodity(Stuff stuff) {
        if(((Material) stuff).getMaterial() == Stuff.Materials.explosives && currentCargoWeight + stuff.getWeight() < maxCargoWeight) {
            commodity.add(stuff);
            currentCargoWeight += stuff.getWeight();
        }
        else
            System.out.println(((Material) stuff).getMaterial() + "cannot be stored there");
    }

}
