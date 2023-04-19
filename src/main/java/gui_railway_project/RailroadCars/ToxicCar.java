package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.HeavyRailroadCar;
import gui_railway_project.Stuff.Material;
import gui_railway_project.Stuff.Stuff;

public class ToxicCar extends HeavyRailroadCar{
    public ToxicCar(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        this.uniqueNum = "TFC" + uniqueNumGenerator;
    }

    public void addCommodity(Stuff stuff) {
        if(((Material) stuff).getMaterial() == Stuff.Materials.toxicMaterial && currentCargoWeight + stuff.getWeight() < maxCargoWeight) {
            commodity.add(stuff);
            currentCargoWeight += stuff.getWeight();
        }
        else
            System.out.println("Wrong freight car");
    }

}
