/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project;


import java.util.UUID;

public class Locomotive {
    
    
    private int maxRailroadCars;
    private int maxWeight;
    private int maxElectricCars;
    private String name;
    private String homeStation;
    private String sourceStation;
    private String destinationStation;
    private String id;
    public double speed;
    public double maxSpeed;

    public Locomotive(String name, int maxRailroadCars, int maxWeight, int maxElectricCars, String homeStation, String sourceStation, String destinationStation) {
        
        this.maxRailroadCars = maxRailroadCars;
        this.maxWeight = maxWeight;
        this.maxElectricCars = maxElectricCars;
        this.name = name;
        this.homeStation = homeStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        
        this.id = UUID.randomUUID().toString();
        speed = 50;
        maxSpeed = 200;
    }

    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMaxElectricCars() {
        return maxElectricCars;
    }

    public String getName() {
        return name;
    }

    public String getHomeStation() {
        return homeStation;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public String getId() {
        return id;
    }
}

