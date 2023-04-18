package gui_railway_project.RailroadCalrs;

import gui_railway_project.Stuffx.Material;
import gui_railway_project.Stuff.Stuff;

public class ExplosivesFreightCar extends HeavyRailroadCar{
    public ExplosivesFreightCar(double carWeight, double maxCargoWeight) {
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
