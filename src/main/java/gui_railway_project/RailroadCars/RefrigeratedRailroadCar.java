package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.BasicRailroadFreightCar;
import gui_railway_project.Stuff.Stuff;
import gui_railway_project.Stuff.Material;
import gui_railway_project.Stuff.Human;
import gui_railway_project.Stuff.Mail;
import gui_railway_project.Stuff.Baggage;

public class RefrigeratedRailroadCar extends BasicRailroadFreightCar{
    public RefrigeratedRailroadCar(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        requireElectricity = true;
        this.uniqueNum = "RRC" + uniqueNumGenerator;
    }

    @Override
    public void addCommodity(Stuff stuff) {
        if(stuff instanceof Material || stuff instanceof Human || stuff instanceof Mail || stuff instanceof Baggage)
            System.out.println(stuff.getClass().getSimpleName() + " cannot be stored here");
        else {
            commodity.add(stuff);
            currentCargoWeight += stuff.getWeight();
        }
    }
}
