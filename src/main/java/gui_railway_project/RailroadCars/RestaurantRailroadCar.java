/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.RailroadCars;

import gui_railway_project.RailroadCars.RailroadCar;
import gui_railway_project.Stuff.Human;
import gui_railway_project.Stuff.Stuff;

import java.util.List;

/**
 *
 * @author Hp
 */
public class RestaurantRailroadCar extends RailroadCar {
    
    private int numberOfSeats;
    private boolean hasKitchen;
    
    public RestaurantRailroadCar(int carWeight, int maxCargoWeight, int numberOfSeats, boolean hasKitchen) {
        super(carWeight, maxCargoWeight);
        this.numberOfSeats = numberOfSeats;
        this.hasKitchen = hasKitchen;
        requireElectricity = true;        
        uniqueNum = "RRC-" + uniqueNumGenerator;
    }
    
}
