package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.RailroadCar;
import gui_railway_project.Stuff.Stuff;

public class RailroadMailandBaggage extends RailroadCar{

    public RailroadMailandBaggage(int carWeight, int maxCargoWeight) {
        super(carWeight, maxCargoWeight);
        this.uniqueNum = "Mail&Baggage" + uniqueNumGenerator;
    }

}
