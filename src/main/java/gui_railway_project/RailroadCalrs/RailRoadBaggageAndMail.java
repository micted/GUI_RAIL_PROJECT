package gui_railway_project.RailroadCalrs;

import gui_railway_project.RailroadCars.RailroadCar;
import gui_railway_project.Stuff.Stuff;

public class RailRoadBaggageAndMail extends RailroadCar{

    public RailRoadBaggageAndMail(double carWeight, double maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        this.uniqueNum = "RBM" + uniqueNumGenerator;
    }

}
