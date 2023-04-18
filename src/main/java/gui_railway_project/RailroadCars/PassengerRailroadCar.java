package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.RailroadCar;
import gui_railway_project.Stuff.Human;
import gui_railway_project.Stuff.Stuff;
import gui_railway_project.Trainset;

public class PassengerRailroadCar extends RailroadCar{

    private int seatsCapacity;
    private int currentNumberOfPassengers;


    public PassengerRailroadCar(int carWeight, int maxCargoWeight, int seatsNumber) {
        super(carWeight, maxCargoWeight);
        this.seatsCapacity = seatsNumber;
        requireElectricity = true;
        currentNumberOfPassengers = 0;
        uniqueNum = "PRC" + uniqueNumGenerator;
    }

    @Override
    public void addCommodity(Stuff stuff) {
        if(currentNumberOfPassengers != seatsCapacity && maxCargoWeight >= currentCargoWeight + stuff.getWeight())
        {
            commodity.add(stuff);
            currentNumberOfPassengers++;
            currentCargoWeight += stuff.getWeight();
        }else
        {
            if(currentNumberOfPassengers >= seatsCapacity)
                System.out.println("No more empty place in this car");
            else if(maxCargoWeight < currentCargoWeight + stuff.getWeight())
                System.out.println("The car is too heavy");
        }
    }

      


}
