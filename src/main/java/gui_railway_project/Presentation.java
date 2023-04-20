package gui_railway_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

import gui_railway_project.Connection;
import gui_railway_project.Exception.CapacityError;
import gui_railway_project.Locomotive;
import gui_railway_project.Station;
import gui_railway_project.RailroadCars.*;
import gui_railway_project.Trainset;
import gui_railway_project.functions.RailwayNetwork;
import gui_railway_project.functions.TrainSegment;
import gui_railway_project.functions.AppStateUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Presentation {
    
    public static void main(String[] args) {
        // Create an ArrayList to store the stations
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<RailroadCar> railroadcars = new ArrayList<>();
        ArrayList<Trainset> trainsets = new ArrayList<>();
        ArrayList<Locomotive> locomotives = new ArrayList<>();
        List<Connection> segments = new ArrayList<>();
        
        RailwayNetwork railnet = new RailwayNetwork();
        
         
         
         AppStateUpdater appStateUpdater = new AppStateUpdater(trainsets);
         appStateUpdater.start();

        // Create 100 europe stations with random coordinates in Europe
        for (int i = 1; i <= 100; i++) {
            String stationName = "Station " + i;
            double latitude = Math.random() * (70.75 - 36.16) + 36.16; // Europe's latitude range
            double longitude = Math.random() * (33.13 - (-22.96)) + (-22.96); // Europe's longitude range
            Station station = new Station(stationName, latitude, longitude);
            stations.add(station);
            railnet.addStation(station);
        }
        
        // Shuffle the stations randomly
        Collections.shuffle(stations);

        // Create connections between the stations in random order
        ArrayList<Connection> connections = new ArrayList<>();
        for (int i = 0; i < stations.size() - 1; i++) {
            Station startStation = stations.get(i);
            Station endStation = stations.get(i + 1);
            String connectionCode = "Connection " + (i + 1);
            Connection connection = new Connection(connectionCode, startStation, endStation, true);
            connections.add(connection);
            railnet.addConnection(connection);
        }

        // Add the last connection to complete the loop
        Station lastStation = stations.get(stations.size() - 1);
        Station firstStation = stations.get(0);
        String connectionCode = "Connection " + stations.size();
        Connection connection = new Connection(connectionCode, lastStation, firstStation, true);
        connections.add(connection);
        
        // print the stations and connections created
        System.out.println("Stations: ");
        for(Station station: stations){
            System.out.println(station.getName() + " (" + station.getLatitude() + ", " + station.getLongitude() + ")");
        }
        
        System.out.println("\nConnections: ");
        for(Connection connectionItem: connections){
            System.out.println(connectionItem.getconnectionCode() + ": " + connectionItem.getStartStation().getName() + " -> " + connectionItem.getEndStation().getName());
        }
        
        
        

        // create a new RestaurantRailroadCar object
        RestaurantRailroadCar restaurantCar = new RestaurantRailroadCar(5000, 2000, 50, true);
        // Create a PassengerRailroadCar object
        PassengerRailroadCar passengerCar = new PassengerRailroadCar(5000, 500, 50);
        // create explosive car
        Explosives explosivesCar = new Explosives(1500, 10000);
        // create gaseous
        GaseousFreightCar gfc = new GaseousFreightCar(5000, 10000);
        // create toxic car
        ToxicCar toxicCar = new ToxicCar(15000, 20000);
        // create mixed
        MixedRail mixedRail = new MixedRail(5000, 10000);
        // create railroadmailandbaggage
        RailroadMailandBaggage mailBaggageCar = new RailroadMailandBaggage(5000, 10000);
        LiquidFreightCar lfc = new LiquidFreightCar(5000, 10000);
        RailroadPostOffice postOffice = new RailroadPostOffice(500, 1000);


        // add different cars to the list of railroad cars then later we can randomly pick car types from the list
        railroadcars.add(restaurantCar);
        railroadcars.add(passengerCar);
        railroadcars.add(explosivesCar);
        railroadcars.add(gfc);
        railroadcars.add(toxicCar);
        railroadcars.add(mixedRail);
        railroadcars.add(lfc);
        railroadcars.add(postOffice);
        
        
        

        // Create 25 locomotives/trainsets with random parameters
        for (int i = 1; i <= 25; i++) {
            String locomotiveName = "Locomotive " + i;
            int maxRailroadCars = (int) (Math.random() * 6 + 5); // between 5 and 10
            int maxWeight = (int) (Math.random() * 100000 + 50000); // between 50,000 and 150,000
            int maxElectricCars = (int) (Math.random() * 4); // between 0 and 3
            String homeStation = "Station " + (int) (Math.random() * 100 + 1); // random station
            String sourceStation = "Station " + (int) (Math.random() * 100 + 1); // random station
            String destinationStation = "Station " + (int) (Math.random() * 100 + 1); // random station
            Locomotive locomotive = new Locomotive(locomotiveName, maxRailroadCars, maxWeight, maxElectricCars, homeStation, sourceStation, destinationStation);
            Trainset trainset = new Trainset(locomotive);  
            
            Random rand = new Random();        
            // randomly select a number of cars between 5 and 10
            int numCars = rand.nextInt(6) + 5;

            // randomly select cars from the list and add them to the train set
            
            for (int nc = 0; nc < numCars; nc++) {
                try {
                    int index = rand.nextInt(railroadcars.size());
                    RailroadCar car = railroadcars.get(index);
                    
                    trainset.addCar(car);
                    System.out.println(trainset.trainsetInfoStr());
                } catch (CapacityError ex) {
                    Logger.getLogger(Presentation.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            trainsets.add(trainset);
            locomotives.add(locomotive);

        }  
        
        
        // DETERMINE ROUTE PATH AND SEGMENT
                                
                                String departureStation = "Station 19";
                                if (!railnet.hasStation(departureStation)) {
                                    System.out.println("Start station does not exist in network.");
                                    
                                }
                                
                                
                                String destinationStation = "Station 13";
                                if (!railnet.hasStation(destinationStation)) {
                                    System.out.println("End station does not exist in network.");
                                    
                                }
                                
                                // Find route and display to user
                                List<String> route = railnet.findRoute(departureStation, destinationStation);
                                
                                
                                for (int i = 0; i < route.size() - 1; i++) {
                                    String startSeg = route.get(i);
                                    String endSeg = route.get(i + 1);
                                    //connection in each segment
                                    Connection segconn = railnet.findConnection(startSeg, endSeg);
                                    segments.add(segconn);
                                }
                                if (route == null) {
                                    System.out.println("No route found.");
                                } else {
                                    System.out.println("Route:");
                                    for (String station : route) {
                                        System.out.println(station);
                                    }
                                    System.out.println(railnet.calculateDistance(route));
                                }
                                
                                
                                // MOVEMENT AND 
                                TrainSegment trainSegment = new TrainSegment(trainsets.get(0), segments, railnet,railnet.calculateDistance(route));
                                trainsets.get(0).setRouteDistance(railnet.calculateDistance(route));
                                
                                // Start train segment in a new thread
                                Thread trainThread = new Thread(trainSegment);
                                trainThread.start();
        
        
    }
}
