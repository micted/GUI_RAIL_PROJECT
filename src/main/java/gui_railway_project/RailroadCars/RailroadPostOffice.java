package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.RailroadCar;
import gui_railway_project.Stuff.Human;
import gui_railway_project.Stuff.Stuff;

import java.util.List;

public class RailroadPostOffice extends RailroadCar{
    //collecting and withdrawal post

    public RailroadPostOffice(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        requireElectricity = true;
        this.uniqueNum = "Rail Postoffice" + uniqueNumGenerator;
    }



}
