/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
import java.util.Scanner;
import gui_railway_project.Locomotive;
import gui_railway_project.RailroadCars.RailroadCar;
import gui_railway_project.Exception.RailroadHazard;
import gui_railway_project.Exception.CapacityError;


public class Trainset {
    
    public static int trainID = 1;
    
    private Locomotive locomotive;
    private List<RailroadCar> railroadCars;
    //private ArrayList<RailroadCar> railroadCars = new ArrayList<>();
    private int maxRailroadCars; // avoid the hardcoding and retrieve the value from locomotive object 
    private int maxWeight; // avoid the hardcoding and retrieve the value from locomotive object
    public double routeDist = 0;
    
    public int id;
    public double trainSpeed;
    public double trainMaxSpeed;
    
    
    // default constructor incase user doesn't pass routeDist or not determine at the moment of trainset creation
   
    
    public Trainset(Locomotive locomotive) {
        this.locomotive = locomotive;
        railroadCars = new ArrayList<>();
        id = trainID++;
        trainSpeed = locomotive.speed;
        trainMaxSpeed = locomotive.maxSpeed;
        this.maxRailroadCars = locomotive.getMaxRailroadCars();
        this.maxWeight = locomotive.getMaxWeight();
        
        
    }


    public void addCar(RailroadCar rc) throws CapacityError
    {

       if (railroadCars.size() >= locomotive.getMaxRailroadCars()) {
            throw new CapacityError();
        }
        if (railroadCars.stream().mapToInt(RailroadCar::getCarWeight).sum() + rc.getCarWeight() > locomotive.getMaxWeight()) {
            throw new CapacityError();
        }
        // If the conditions are met, add the new railroad car to the array.
        railroadCars.add(rc);
        // Sort the railroad cars by weight
        railroadCars.sort(Comparator.comparing(RailroadCar::getCarWeight));
    }

    public void removeCar()
    {
        System.out.println("Choose railroad car to remove");
        String car = new Scanner(System.in).next();
        System.out.println(railroadCars.size());
        for(RailroadCar railroadCar : railroadCars)
        {
            if(railroadCar.getUniqueNum().equalsIgnoreCase(car))
            {
                
                railroadCars.remove(railroadCar);
                break;
            }
        }
        System.out.println("Successfully removed");
        System.out.println(railroadCars.size());

    }

    

    
    public void trainsetInfo()
    {
        System.out.println(locomotive);
        for(RailroadCar railroadCar : railroadCars)
            System.out.println(railroadCar);
    }
    
    public String trainsetInfoStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name"+" "+ locomotive.getName()).append("|");
        sb.append("TrainID"+" "+ this.id).append("|");
        sb.append("RouteLength"+" "+ this.getRouteDistance()).append("|");
        sb.append("CurrentSpeed"+" "+ this.getSpeed()).append("|");
        for (RailroadCar railroadCar : railroadCars) {
            sb.append("Car-ID"+" "+railroadCar.getUniqueNum()).append("|");
        }
        return sb.toString();
    }



    public int getNumRailroadCars() {
        return railroadCars.size();
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<RailroadCar> getRailroadCars() {
        return railroadCars;
    }

    public void setRailroadCars(ArrayList<RailroadCar> railroadCars) {
        this.railroadCars = railroadCars;
    }

    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }

    public void setMaxRailroadCars(int maxRailroadCars) {
        this.maxRailroadCars = maxRailroadCars;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    public double getSpeed() {
        
        return trainSpeed;    
    }
    
    public void setSpeed(double speed) {
        this.trainSpeed = speed;
    }
    
    public void move(Connection seg, double currentSpeed) throws RailroadHazard {
        
        if(currentSpeed > 200)
            throw new RailroadHazard();
        
        // Calculate the distance between the start and end nodes using the Euclidean distance formula
        double distance = seg.getDistance();

        // Calculate the time required to travel the distance at the maximum speed
        double time = distance / currentSpeed;

        
        
        //currentDistanceCovered += distance;
    }
    
    public void setRouteDistance(double routeDist) {
        this.routeDist = routeDist;
    }
    
    public double getRouteDistance() {
        return routeDist;
    }
    
    
    
    /*
    public void move(int distance) {
        int currentDistance = distanceTraveled + distance;
        if (currentDistance >= totalDistance) {
            currentDistance = totalDistance;
        }

        // Check speed limit
        double speed = locomotive.getSpeed();
        if (speed > 200) {
            String trainsetInfo = getTrainsetInfo();
            String message = "Warning: Trainset " + trainsetId + " (" + trainsetName + ") exceeds speed limit (200 km/h).";
            throw new RailroadHazard(trainsetInfo, message);
        }

        distanceTraveled = currentDistance;
    }




   /*
    public void move(int distance) throws RailroadHazard {
        int currentDistance = distanceTraveled + distance;
        if (currentDistance >= totalDistance) {
            currentDistance = totalDistance;
        }

        // Check speed limit
        double speed = locomotive.getSpeed();
        if (speed > 200) {
            throw new RailroadHazard(getTrainsetInfo() + "\nWarning: Trainset exceeds speed limit (200 km/h).");
        }

        distanceTraveled = currentDistance;
    }

    
     * public class RailroadHazard extends Exception {

    public RailroadHazard(String message) {
        super(message);
    }
    }

     */
    
}

   

