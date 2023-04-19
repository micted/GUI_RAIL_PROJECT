package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.LiquidFreightCar;
import gui_railway_project.Stuff.Human;
import gui_railway_project.Stuff.Material;
import gui_railway_project.Stuff.Stuff;


public class MixedRail extends LiquidFreightCar {
    public MixedRail(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        this.uniqueNum = "MFC" + uniqueNumGenerator;
    }

    public void addCommodity(Stuff stuff) {
        if((((Material) stuff).getMaterial() == Stuff.Materials.liquidMaterial || ((Material) stuff).getMaterial() == Stuff.Materials.toxicMaterial )&& currentCargoWeight + stuff.getWeight() <= maxCargoWeight) {
            commodity.add(stuff);
            currentCargoWeight += stuff.getWeight();
        }
        else
            System.out.println(((Material) stuff).getMaterial() + "cannot be stored there");
    }


}
